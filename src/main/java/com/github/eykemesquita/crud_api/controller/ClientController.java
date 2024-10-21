package com.github.eykemesquita.crud_api.controller;

import com.github.eykemesquita.crud_api.dto.ClientDto;
import com.github.eykemesquita.crud_api.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clientes", description = "Endpoints para gerenciamento de clientes")
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Criar um novo cliente", description = "Adiciona um novo cliente ao sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = """
                {
                    "id": 1,
                    "docNumber": "12345678901",
                    "name": "John Doe",
                    "email": "johndoe@example.com",
                    "phone": "555-1234",
                    "birthDate": "1990-01-01",
                    "stateInscription": "RJ",
                    "municipalInscription": "Bridge",
                    "createdBy": "Admin",
                    "modifiedBy": "Admin",
                    "emailOptIn": true,
                    "smsOptIn": false,
                    "whatsappOptIn": true,
                    "pushOptIn": false
                }"""
                            )
                    )),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        return new ResponseEntity<>(clientService.createClient(clientDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Obter cliente por ID", description = "Recupera os dados do cliente pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @Operation(summary = "Listar todos os clientes", description = "Recupera todos os clientes com filtragem e paginação opcionais")
    @Parameters({
            @Parameter(name = "name", description = "Filtrar pelo nome do cliente", example = "John"),
            @Parameter(name = "page", description = "Número da página para paginação", example = "0"),
            @Parameter(name = "size", description = "Número de clientes por página", example = "10"),
            @Parameter(name = "sort", description = "Critérios de ordenação (ex. 'name,asc')", example = "name,asc")
    })
    @ApiResponse(responseCode = "200", description = "Lista de clientes recuperada com sucesso")
    @GetMapping
    public ResponseEntity<Page<ClientDto>> getAllClients(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name,asc") String sort) {
        return ResponseEntity.ok(clientService.getAllClients(name, page, size, sort));
    }

    @Operation(summary = "Atualizar cliente", description = "Atualiza os detalhes de um cliente com base no ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PutMapping("{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody ClientDto updatedClient) {
        return ResponseEntity.ok(clientService.updateClient(id, updatedClient));
    }

    @Operation(summary = "Deletar cliente", description = "Remove um cliente com base no ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Cliente deletado com sucesso!");
    }
}
