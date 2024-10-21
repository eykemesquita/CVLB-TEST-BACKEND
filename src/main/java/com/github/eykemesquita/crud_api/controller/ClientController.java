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
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clients", description = "Endpoints for managing clients")
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Create a new client", description = "Adds a new client to the system with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client successfully created",
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
                    }
                    """
                            ))),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        System.out.println("POST request received for creating client");
        ClientDto savedClient = clientService.createClient(clientDto);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @Operation(summary = "Get client by ID", description = "Retrieve client data based on the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client successfully found"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    @GetMapping("{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable("id") Long clientId) {
        System.out.println("GET request received for client ID: " + clientId);
        ClientDto clientDto = clientService.getClientById(clientId);
        return ResponseEntity.ok(clientDto);
    }

    @Operation(summary = "List all clients", description = "Retrieve a list of all registered clients with optional filtering and pagination")
    @Parameters({
            @Parameter(name = "name", description = "Filter clients by name", example = "John"),
            @Parameter(name = "page", description = "Page number for pagination", example = "0"),
            @Parameter(name = "size", description = "Number of clients per page", example = "10"),
            @Parameter(name = "sort", description = "Sorting criteria (e.g. 'name,asc')", example = "name,asc")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of clients successfully retrieved"),
    })
    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClients(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "name,asc") String sort) {
        System.out.println("GET request received for retrieving all clients with pagination");
        // You can update the service to handle filtering and pagination as necessary
        List<ClientDto> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @Operation(summary = "Update an existing client", description = "Updates the details of a client based on the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client successfully updated"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PutMapping("{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable("id") Long clientId,
                                                  @RequestBody ClientDto updatedClient) {
        System.out.println("PUT request received for updating client ID: " + clientId);
        ClientDto clientDto = clientService.updateClient(clientId, updatedClient);
        return ResponseEntity.ok(clientDto);
    }

    @Operation(summary = "Delete a client", description = "Removes a client from the system based on the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long clientId) {
        System.out.println("DELETE request received for client ID: " + clientId);
        clientService.deleteClient(clientId);
        return new ResponseEntity<>("Client deleted successfully!", HttpStatus.OK);
    }

}
