package org.example.spring.web.controllers;

import org.example.spring.web.dto.request.ClientSimpleCreate;
import org.example.spring.web.dto.response.ClientSimpleResponse;
import org.example.spring.web.dto.response.ClientWithCommandeResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("api/v1/clients")
public interface ClientController {
    @GetMapping("")
    ResponseEntity<Page<ClientSimpleResponse>> getAllClients(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "8") int size
    );

    @GetMapping("/{id}")
    ResponseEntity<ClientSimpleResponse> getOne(@PathVariable() Long id);

    @PostMapping("/")
    ResponseEntity<ClientSimpleResponse> createClient(@RequestBody() ClientSimpleCreate clientRequest);

    @PutMapping("/{id}")
    ResponseEntity<ClientSimpleResponse> updateClient(@PathVariable() Long id, @RequestBody() ClientSimpleCreate clientRequest);

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteClient(@PathVariable() Long id);
    @GetMapping("/{id}/commandes")
    ResponseEntity<ClientWithCommandeResponse> getClientWithCommande(@PathVariable(name = "id") Long clientId);
}
