package com.github.eykemesquita.crud_api.service;

import com.github.eykemesquita.crud_api.dto.ClientDto;
import org.springframework.data.domain.Page;
import java.util.List;

public interface ClientService {

    // Cria um novo cliente
    ClientDto createClient(ClientDto clientDto);

    // Busca um cliente pelo ID
    ClientDto getClientById(Long clientId);

    // Retorna uma lista de todos os clientes
    List<ClientDto> getAllClients();

    // Atualiza as informações de um cliente com base no ID fornecido
    ClientDto updateClient(Long clientId, ClientDto updatedClient);

    // Remove um cliente com base no ID fornecido
    void deleteClient(Long clientId);

    // Cria ou atualiza um cliente, dependendo se já existe ou não
    ClientDto createOrUpdateClient(ClientDto clientDto);

    // Retorna uma lista paginada de clientes, com opções de filtro, página, tamanho e ordenação
    Page<ClientDto> getAllClients(String name, int page, int size, String sort);
}
