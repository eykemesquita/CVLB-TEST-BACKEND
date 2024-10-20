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

    private Client findClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client does not exist with the given ID : " + clientId));
    }

    private void saveClientAddresses(List<AddressDto> addressList, Client client) {
        if (addressList != null && !addressList.isEmpty()) {
            List<Address> addresses = addressList.stream()
                    .map(addressDto -> mapToAddress(addressDto, client))
                    .collect(Collectors.toList());
            addressRepository.saveAll(addresses);
        }
    }

    private Address mapToAddress(AddressDto addressDto, Client client) {
        Address address = new Address();
        address.setClient(client);
        BeanUtils.copyProperties(addressDto, address, "client"); // Copia as propriedades de addressDto para address
        return address;
    }
}
