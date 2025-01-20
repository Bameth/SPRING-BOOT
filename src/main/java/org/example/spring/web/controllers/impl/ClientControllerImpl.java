package org.example.spring.web.controllers.impl;

import org.example.spring.data.entities.Client;
import org.example.spring.services.ClientService;
import org.example.spring.web.controllers.ClientController;
import org.example.spring.web.dto.request.ClientSimpleCreate;
import org.example.spring.web.dto.response.ClientSimpleResponse;
import org.example.spring.web.dto.response.ClientWithCommandeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    @Override
    public ResponseEntity<Page<ClientSimpleResponse>> getAllClients(int page, int size) {
       Pageable pageable = PageRequest.of(page, size);
       Page<Client> clients = clientService.getAllClients(pageable);
       Page<ClientSimpleResponse> clientResponseDto = clients.map(ClientSimpleResponse::new);
       return new ResponseEntity<Page<ClientSimpleResponse>>(clientResponseDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClientSimpleResponse> getOne(Long id) {
        var client = clientService.getById(id);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(new ClientSimpleResponse(client), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<ClientSimpleResponse> createClient(ClientSimpleCreate clientRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createClient'");
    }

    @Override
    public ResponseEntity<ClientSimpleResponse> updateClient(Long id, ClientSimpleCreate clientRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateClient'");
    }

    @Override
    public ResponseEntity<String> deleteClient(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteClient'");
    }

    @Override
    public ResponseEntity<ClientWithCommandeResponse> getClientWithCommande(Long clientId) {
        var client = clientService.getById(clientId);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(new ClientWithCommandeResponse(client), HttpStatus.OK);
        }
    }

}
