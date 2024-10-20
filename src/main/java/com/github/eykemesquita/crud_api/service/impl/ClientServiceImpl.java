package com.github.eykemesquita.crud_api.service.impl;

import com.github.eykemesquita.crud_api.dto.ClientDto;
import com.github.eykemesquita.crud_api.entity.Client;
import com.github.eykemesquita.crud_api.exception.ResourceNotFoundException;
import com.github.eykemesquita.crud_api.mapper.ClientMapper;
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

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = ClientMapper.mapToClient(clientDto);
        client.setCreatedDate(LocalDateTime.now());
        client.setModifiedDate(LocalDateTime.now());

        Client savedClient = clientRepository.save(client);
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
        return ClientMapper.mapToClientDto(updatedClient);
    }

    @Override
    public void deleteClient(Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new ResourceNotFoundException("Client does not exist with the given ID : " + clientId);
        }
        clientRepository.deleteById(clientId);
    }

    // Método auxiliar para buscar cliente por ID
    private Client findClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client does not exist with the given ID : " + clientId));
    }
}
