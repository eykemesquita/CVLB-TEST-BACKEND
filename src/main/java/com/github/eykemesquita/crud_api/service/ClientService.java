package com.github.eykemesquita.crud_api.service;

import com.github.eykemesquita.crud_api.dto.ClientDto;


public interface ClientService {

    ClientDto createClient(ClientDto clientDto);

    ClientDto getClientById(Long clientDto);
}
