package com.github.eykemesquita.crud_api.service;

import com.github.eykemesquita.crud_api.dto.ClientDto;
import com.github.eykemesquita.crud_api.entity.Client;
import com.github.eykemesquita.crud_api.exception.ResourceNotFoundException;
import com.github.eykemesquita.crud_api.mapper.ClientMapper;
import com.github.eykemesquita.crud_api.repository.ClientRepository;
import com.github.eykemesquita.crud_api.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateClient() {
        ClientDto clientDto = new ClientDto();
        clientDto.setName("Test Client");
        clientDto.setEmail("test@test.com");
        clientDto.setDocNumber("12345678901");

        Client client = ClientMapper.mapToClient(clientDto);
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        ClientDto result = clientService.createClient(clientDto);
        verify(clientRepository, times(1)).save(any(Client.class));
    }

    @Test
    public void testGetClientById() {
        Client client = new Client();
        client.setId(1L);
        client.setName("João");
        client.setEmail("joao@example.com");

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        ClientDto result = clientService.getClientById(1L);

        assertNotNull(result);
        assertEquals("João", result.getName());
        assertEquals("joao@example.com", result.getEmail());
    }

    @Test
    public void testGetClientById_NotFound() {
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> clientService.getClientById(1L));
    }

    @Test
    public void testUpdateClient() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Maria");
        client.setEmail("maria@example.com");

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        when(clientRepository.save(any(Client.class))).thenReturn(client);
        ClientDto updatedClientDto = new ClientDto();
        updatedClientDto.setName("Maria Atualizada");
        updatedClientDto.setEmail("maria.atualizada@example.com");

        ClientDto result = clientService.updateClient(1L, updatedClientDto);

        assertEquals("Maria Atualizada", result.getName());
        assertEquals("maria.atualizada@example.com", result.getEmail());
    }

    @Test
    public void testDeleteClient() {
        Client client = new Client();
        client.setId(1L);
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        clientService.deleteClient(1L);

        verify(clientRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteClient_NotFound() {
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> clientService.deleteClient(1L));

        verify(clientRepository, never()).deleteById(anyLong());
    }

    @Test
    public void testCreateClient_EmailAlreadyExists() {
        when(clientRepository.existsByEmail("test@test.com")).thenReturn(true);

        ClientDto clientDto = new ClientDto();
        clientDto.setName("Test Client");
        clientDto.setEmail("test@test.com");

        assertThrows(IllegalArgumentException.class, () -> clientService.createClient(clientDto));

        verify(clientRepository, never()).save(any(Client.class));
    }

    @Test
    public void testUpdateClient_NotFound() {
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        ClientDto updatedClientDto = new ClientDto();
        updatedClientDto.setName("Maria Atualizada");
        updatedClientDto.setEmail("maria.atualizada@example.com");

        assertThrows(ResourceNotFoundException.class, () -> clientService.updateClient(1L, updatedClientDto));

        verify(clientRepository, never()).save(any(Client.class));
    }


    @Test
    public void testFindByEmail() {
        Client client = new Client();
        client.setId(1L);
        client.setName("João");
        client.setEmail("joao@example.com");

        when(clientRepository.findByEmail("joao@example.com")).thenReturn(Optional.of(client));

        ClientDto result = clientService.getClientByEmail("joao@example.com");

        assertNotNull(result);
        assertEquals("João", result.getName());
        assertEquals("joao@example.com", result.getEmail());
    }

    @Test
    public void testFindByNameContaining() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Test Client");
        client.setEmail("test@test.com");

        Pageable pageable = PageRequest.of(0, 10); // Exemplo de paginação
        Page<Client> clientPage = new PageImpl<>(Collections.singletonList(client), pageable, 1);

        when(clientRepository.findByNameContainingIgnoreCase(eq("Test Client"), eq(pageable)))
                .thenReturn(clientPage);

        Page<ClientDto> result = clientService.findClientsByName("Test Client", pageable);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.getTotalElements());
        assertEquals("Test Client", result.getContent().get(0).getName());
    }

}
