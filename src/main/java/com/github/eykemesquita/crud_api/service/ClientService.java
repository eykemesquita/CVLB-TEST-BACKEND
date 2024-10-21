package com.github.eykemesquita.crud_api.service;

import com.github.eykemesquita.crud_api.dto.ClientDto;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ClientService {

    ClientDto createClient(ClientDto clientDto);

    ClientDto getClientById(Long clientDto);

    List<ClientDto> getAllClients();

    ClientDto updateClient(Long clientId, ClientDto updatedClient);

    void deleteClient(Long clientId);

    ClientDto createOrUpdateClient(ClientDto clientDto);

    Page<ClientDto> getAllClients(String name, int page, int size, String sort);

}
