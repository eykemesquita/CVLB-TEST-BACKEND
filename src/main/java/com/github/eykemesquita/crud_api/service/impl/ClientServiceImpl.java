package com.github.eykemesquita.crud_api.service.impl;

import com.github.eykemesquita.crud_api.dto.ClientDto;
import com.github.eykemesquita.crud_api.entity.Client;
import com.github.eykemesquita.crud_api.mapper.ClientMapper;
import com.github.eykemesquita.crud_api.repository.ClientRepository;
import com.github.eykemesquita.crud_api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public ClientDto getClientById(Long clientDto) {
        return null;
    }
}
