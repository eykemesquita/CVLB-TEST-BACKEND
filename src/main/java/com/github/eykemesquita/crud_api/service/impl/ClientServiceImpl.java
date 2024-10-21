package com.github.eykemesquita.crud_api.service.impl;

import com.github.eykemesquita.crud_api.dto.AddressDto;
import com.github.eykemesquita.crud_api.dto.ClientDto;
import com.github.eykemesquita.crud_api.entity.Address;
import com.github.eykemesquita.crud_api.entity.Client;
import com.github.eykemesquita.crud_api.exception.ResourceNotFoundException;
import com.github.eykemesquita.crud_api.mapper.ClientMapper;
import com.github.eykemesquita.crud_api.repository.AddressRepository;
import com.github.eykemesquita.crud_api.repository.ClientRepository;
import com.github.eykemesquita.crud_api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        // Verifica se o email ou docNumber já existe
        if (clientRepository.existsByEmail(clientDto.getEmail())) {
            throw new IllegalArgumentException("Client with email " + clientDto.getEmail() + " already exists");
        }

        if (clientRepository.existsByDocNumber(clientDto.getDocNumber())) {
            throw new IllegalArgumentException("Client with document number " + clientDto.getDocNumber() + " already exists");
        }

        Client client = ClientMapper.mapToClient(clientDto);
        client.setCreatedDate(LocalDateTime.now());
        client.setModifiedDate(LocalDateTime.now());

        Client savedClient = clientRepository.save(client);
        saveClientAddresses(clientDto.getAddressList(), savedClient);

        return ClientMapper.mapToClientDto(savedClient);
    }

    @Override
    public ClientDto getClientById(Long clientId) {
        Client client = findClientById(clientId);
        return ClientMapper.mapToClientDto(client);
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientMapper::mapToClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto updateClient(Long clientId, ClientDto updatedClientDto) {
        Client client = findClientById(clientId);

        client.setDocNumber(updatedClientDto.getDocNumber());
        client.setName(updatedClientDto.getName());
        client.setEmail(updatedClientDto.getEmail());
        client.setPhone(updatedClientDto.getPhone());
        client.setBirthDate(updatedClientDto.getBirthDate());
        client.setEmployee(updatedClientDto.isEmployee());
        client.setStateInscription(updatedClientDto.getStateInscription());
        client.setMunicipalInscription(updatedClientDto.getMunicipalInscription());
        client.setBlocked(updatedClientDto.isBlocked());
        client.setEmailOptIn(updatedClientDto.isEmailOptIn());
        client.setSmsOptIn(updatedClientDto.isSmsOptIn());
        client.setWhatsappOptIn(updatedClientDto.isWhatsappOptIn());
        client.setPushOptIn(updatedClientDto.isPushOptIn());

        client.setModifiedDate(LocalDateTime.now());

        Client updatedClient = clientRepository.save(client);

        saveClientAddresses(updatedClientDto.getAddressList(), updatedClient);

        return ClientMapper.mapToClientDto(updatedClient);
    }

    @Override
    public void deleteClient(Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new ResourceNotFoundException("Client does not exist with the given ID : " + clientId);
        }
        clientRepository.deleteById(clientId);
    }

    @Override
    public ClientDto createOrUpdateClient(ClientDto clientDto) {
        // Verifica se o cliente com o email já existe no banco de dados
        Client client = clientRepository.findByEmail(clientDto.getEmail())
                .orElse(ClientMapper.mapToClient(clientDto)); // Cria novo cliente se não existir

        // Atualiza as informações do cliente
        client.setDocNumber(clientDto.getDocNumber());
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setPhone(clientDto.getPhone());
        client.setBirthDate(clientDto.getBirthDate());
        client.setEmployee(clientDto.isEmployee());
        client.setStateInscription(clientDto.getStateInscription());
        client.setMunicipalInscription(clientDto.getMunicipalInscription());
        client.setBlocked(clientDto.isBlocked());
        client.setEmailOptIn(clientDto.isEmailOptIn());
        client.setSmsOptIn(clientDto.isSmsOptIn());
        client.setWhatsappOptIn(clientDto.isWhatsappOptIn());
        client.setPushOptIn(clientDto.isPushOptIn());

        client.setModifiedDate(LocalDateTime.now()); // Atualiza a data de modificação

        // Salva o cliente no banco de dados
        Client savedClient = clientRepository.save(client);

        // Salva os endereços do cliente
        saveClientAddresses(clientDto.getAddressList(), savedClient);

        // Retorna o DTO atualizado do cliente
        return ClientMapper.mapToClientDto(savedClient);
    }


    @Override
    public Page<ClientDto> getAllClients(String name, int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, getSort(sort));

        Page<Client> clientPage;
        if (name != null && !name.isEmpty()) {
            clientPage = clientRepository.findByNameContainingIgnoreCase(name, pageable);
        } else {
            clientPage = clientRepository.findAll(pageable);
        }

        return clientPage.map(ClientMapper::mapToClientDto);
    }


    private Sort getSort(String sort) {
        try {
            String[] sortParams = sort.split(",");
            String field = sortParams[0]; // Campo para ordenar
            Sort.Direction direction = Sort.Direction.fromString(sortParams.length > 1 ? sortParams[1] : "asc"); // Direção (asc ou desc)
            return Sort.by(direction, field);
        } catch (Exception e) {
            return Sort.by(Sort.Direction.ASC, "name"); // fallback para ordenar por nome se o parâmetro for inválido
        }
    }

    private Client findClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client does not exist with the given ID : " + clientId));
    }

    private void saveClientAddresses(List<AddressDto> addressList, Client client) {
        if (addressList != null && !addressList.isEmpty()) {
            List<Address> addresses = addressList.stream()
                    .map(addressDto -> mapToAddress(addressDto, client))
                    .collect(Collectors.toList());

            List<Address> existingAddresses = addressRepository.findByClientId(client.getId());

            for (Address address : existingAddresses) {
                if (!addresses.contains(address)) {
                    addressRepository.delete(address); // Remove os endereços que não estão mais associados ao cliente
                }
            }

            addressRepository.saveAll(addresses); // Salva os novos endereços ou atualiza os existentes
        }
    }


    private Address mapToAddress(AddressDto addressDto, Client client) {
        Address address = new Address();
        address.setClient(client);
        BeanUtils.copyProperties(addressDto, address, "client"); // Copia as propriedades de addressDto para address
        return address;
    }
}
