package com.github.eykemesquita.crud_api.controller;

import com.github.eykemesquita.crud_api.dto.ClientDto;
import com.github.eykemesquita.crud_api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        System.out.println("POST request received for creating client");
        ClientDto savedClient = clientService.createClient(clientDto);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable("id") Long clientId) {
        System.out.println("GET request received for client ID: " + clientId);
        ClientDto clientDto = clientService.getClientById(clientId);
        return ResponseEntity.ok(clientDto);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClients() {
        System.out.println("GET request received for retrieving all clients");
        List<ClientDto> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable("id") Long clientId,
                                                  @RequestBody ClientDto updatedClient) {
        System.out.println("PUT request received for updating client ID: " + clientId);
        ClientDto clientDto = clientService.updateClient(clientId, updatedClient);
        return ResponseEntity.ok(clientDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long clientId) {
        System.out.println("DELETE request received for client ID: " + clientId);
        clientService.deleteClient(clientId);
        return new ResponseEntity<>("Client deleted successfully!", HttpStatus.OK);
    }

}
