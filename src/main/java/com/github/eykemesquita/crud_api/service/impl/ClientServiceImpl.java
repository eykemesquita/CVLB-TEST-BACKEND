package com.github.eykemesquita.crud_api.service.impl;

import com.github.eykemesquita.crud_api.dto.ClientDto;
import com.github.eykemesquita.crud_api.entity.Client;
import com.github.eykemesquita.crud_api.exception.ResourceNotFoundException;
import com.github.eykemesquita.crud_api.mapper.ClientMapper;
import com.github.eykemesquita.crud_api.repository.ClientRepository;
import com.github.eykemesquita.crud_api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;

    @Override
    public ClientDto createClient(ClientDto clientDto) {

        Client client = ClientMapper.mapToClient(clientDto);
        Client savedClient = clientRepository.save(client);

        return ClientMapper.mapToClientDto(savedClient);
    }

    @Override
    public ClientDto getClientById(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Client does not exist with the given ID : " + clientId));
        return ClientMapper.mapToClientDto(client);
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(ClientMapper::mapToClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto updateClient(Long clientId, ClientDto updatedClient) {

       Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException("Client does not exist with the given ID : " + clientId)
        );

       client.setDocNumber(updatedClient.getDocNumber());
       client.setName(updatedClient.getName());
       client.setEmail(updatedClient.getEmail());
       client.setPhone(updatedClient.getPhone());
       client.setBirthDate(updatedClient.getBirthDate());
       client.setEmployee(updatedClient.isEmployee());
       client.setStateInscription(updatedClient.getStateInscription());
       client.setMunicipalInscription(updatedClient.getMunicipalInscription());
       client.setBlocked(updatedClient.isBlocked());
       client.setCreatedBy(updatedClient.getCreatedBy());
       client.setModifiedBy(updatedClient.getModifiedBy());
       client.setCreatedDate(updatedClient.getCreatedDate());
       client.setModifiedDate(updatedClient.getModifiedDate());
       client.setEmail(updatedClient.getEmail());
       client.setSmsOptIn(updatedClient.isSmsOptIn());
       client.setWhatsappOptIn(updatedClient.isWhatsappOptIn());
       client.setPushOptIn(updatedClient.isPushOptIn());

      Client updatedClientObj = clientRepository.save(client);

        return ClientMapper.mapToClientDto(updatedClientObj);
    }

    @Override
    public void deleteClient(Long clientId) {

        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException("Client does not exist with the given ID : " + clientId)
        );

        clientRepository.deleteById(clientId);

    }
}
