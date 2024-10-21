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

/**
 * Classe de testes unitários para o ClientServiceImpl.
 * Esta classe utiliza Mockito para simular o comportamento do ClientRepository
 * e garantir a execução de cenários de sucesso e exceções.
 */
public class ClientServiceImplTest {

    // Mock do repositório de clientes
    @Mock
    private ClientRepository clientRepository;

    // Classe de serviço com os mocks injetados
    @InjectMocks
    private ClientServiceImpl clientService;

    /**
     * Método de configuração que inicializa os mocks antes de cada teste.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testa a criação de um cliente verificando se o método save foi chamado corretamente.
     */
    @Test
    void testCreateClient() {
        // Simula os dados do cliente que será criado
        ClientDto clientDto = new ClientDto();
        clientDto.setName("Test Client");
        clientDto.setEmail("test@test.com");
        clientDto.setDocNumber("12345678901");

        // Mapeia o DTO para a entidade e simula o comportamento do repositório
        Client client = ClientMapper.mapToClient(clientDto);
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        // Executa o método de criação do serviço
        ClientDto result = clientService.createClient(clientDto);

        // Verifica se o método save foi chamado e o cliente foi salvo
        verify(clientRepository, times(1)).save(any(Client.class));
    }

    /**
     * Testa a busca de um cliente por ID e verifica se o retorno é correto.
     */
    @Test
    public void testGetClientById() {
        // Simula o cliente que será retornado pelo repositório
        Client client = new Client();
        client.setId(1L);
        client.setName("João");
        client.setEmail("joao@example.com");

        // Simula o comportamento do repositório ao buscar um cliente por ID
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        // Executa o método de busca no serviço
        ClientDto result = clientService.getClientById(1L);

        // Verifica se o cliente retornado tem os dados corretos
        assertNotNull(result);
        assertEquals("João", result.getName());
        assertEquals("joao@example.com", result.getEmail());
    }

    /**
     * Testa o caso onde o cliente não é encontrado por ID e verifica se a exceção é lançada.
     */
    @Test
    public void testGetClientById_NotFound() {
        // Simula a ausência do cliente no repositório
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        // Verifica se a exceção ResourceNotFoundException é lançada
        assertThrows(ResourceNotFoundException.class, () -> clientService.getClientById(1L));
    }

    /**
     * Testa a atualização de um cliente existente.
     */
    @Test
    public void testUpdateClient() {
        // Simula o cliente que será atualizado
        Client client = new Client();
        client.setId(1L);
        client.setName("Maria");
        client.setEmail("maria@example.com");

        // Simula o comportamento do repositório ao buscar e salvar o cliente
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        // Cria um DTO com os dados atualizados
        ClientDto updatedClientDto = new ClientDto();
        updatedClientDto.setName("Maria Atualizada");
        updatedClientDto.setEmail("maria.atualizada@example.com");

        // Executa o método de atualização no serviço
        ClientDto result = clientService.updateClient(1L, updatedClientDto);

        // Verifica se os dados foram atualizados corretamente
        assertEquals("Maria Atualizada", result.getName());
        assertEquals("maria.atualizada@example.com", result.getEmail());
    }

    /**
     * Testa a exclusão de um cliente existente por ID.
     */
    @Test
    public void testDeleteClient() {
        // Simula o cliente que será deletado
        Client client = new Client();
        client.setId(1L);
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        // Executa o método de exclusão no serviço
        clientService.deleteClient(1L);

        // Verifica se o método deleteById foi chamado com o ID correto
        verify(clientRepository, times(1)).deleteById(1L);
    }

    /**
     * Testa o caso onde o cliente a ser deletado não é encontrado.
     */
    @Test
    public void testDeleteClient_NotFound() {
        // Simula que o cliente não foi encontrado
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        // Verifica se a exceção ResourceNotFoundException é lançada ao tentar deletar um cliente inexistente
        assertThrows(ResourceNotFoundException.class, () -> clientService.deleteClient(1L));

        // Verifica que o método deleteById nunca foi chamado
        verify(clientRepository, never()).deleteById(anyLong());
    }

    /**
     * Testa a tentativa de criação de um cliente com um email que já existe.
     */
    @Test
    public void testCreateClient_EmailAlreadyExists() {
        // Simula que o email já existe no repositório
        when(clientRepository.existsByEmail("test@test.com")).thenReturn(true);

        // Cria um DTO de cliente com o email já existente
        ClientDto clientDto = new ClientDto();
        clientDto.setName("Test Client");
        clientDto.setEmail("test@test.com");

        // Verifica se uma exceção é lançada ao tentar criar o cliente
        assertThrows(IllegalArgumentException.class, () -> clientService.createClient(clientDto));

        // Verifica que o método save não foi chamado
        verify(clientRepository, never()).save(any(Client.class));
    }

    /**
     * Testa a tentativa de atualizar um cliente que não existe.
     */
    @Test
    public void testUpdateClient_NotFound() {
        // Simula que o cliente não foi encontrado
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        // Cria um DTO de cliente atualizado
        ClientDto updatedClientDto = new ClientDto();
        updatedClientDto.setName("Maria Atualizada");
        updatedClientDto.setEmail("maria.atualizada@example.com");

        // Verifica se a exceção ResourceNotFoundException é lançada ao tentar atualizar o cliente inexistente
        assertThrows(ResourceNotFoundException.class, () -> clientService.updateClient(1L, updatedClientDto));

        // Verifica que o método save não foi chamado
        verify(clientRepository, never()).save(any(Client.class));
    }

    /**
     * Testa a busca de um cliente por email.
     */
    @Test
    public void testFindByEmail() {
        // Simula um cliente encontrado por email
        Client client = new Client();
        client.setId(1L);
        client.setName("João");
        client.setEmail("joao@example.com");

        // Simula o comportamento do repositório ao buscar o cliente por email
        when(clientRepository.findByEmail("joao@example.com")).thenReturn(Optional.of(client));

        // Executa o método de busca por email no serviço
        ClientDto result = clientService.getClientByEmail("joao@example.com");

        // Verifica se os dados retornados estão corretos
        assertNotNull(result);
        assertEquals("João", result.getName());
        assertEquals("joao@example.com", result.getEmail());
    }

    /**
     * Testa a busca paginada de clientes contendo um determinado nome.
     */
    @Test
    public void testFindByNameContaining() {
        // Simula um cliente e configura a paginação
        Client client = new Client();
        client.setId(1L);
        client.setName("Test Client");
        client.setEmail("test@test.com");

        // Configura a paginação para a busca
        Pageable pageable = PageRequest.of(0, 10); // Configura a paginação (página 0, 10 itens por página)
        Page<Client> clientPage = new PageImpl<>(Collections.singletonList(client), pageable, 1); // Página contendo 1 cliente

        // Simula o comportamento do repositório ao buscar clientes pelo nome (ignorando maiúsculas e minúsculas)
        when(clientRepository.findByNameContainingIgnoreCase(eq("Test Client"), eq(pageable)))
                .thenReturn(clientPage);

        // Executa o método de busca no serviço
        Page<ClientDto> result = clientService.findClientsByName("Test Client", pageable);

        // Verifica se o resultado não é nulo e contém o cliente esperado
        assertNotNull(result); // Verifica se a página retornada não é nula
        assertFalse(result.isEmpty()); // Verifica se a página não está vazia
        assertEquals(1, result.getTotalElements()); // Verifica se há exatamente 1 cliente retornado
        assertEquals("Test Client", result.getContent().get(0).getName()); // Verifica se o nome do cliente está correto
    }
}
