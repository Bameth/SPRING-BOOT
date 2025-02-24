package org.example.spring.web.controllers.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.spring.data.entities.Client;
import org.example.spring.services.ClientService;
import org.example.spring.web.controllers.ClientController;
import org.example.spring.web.dto.RestResponse;
import org.example.spring.web.dto.request.ClientSimpleCreate;
import org.example.spring.web.dto.response.ClientSimpleResponse;
import org.example.spring.web.dto.response.ClientWithCommandeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    @Override
    public ResponseEntity<Map<String, Object>> getAllClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clients = clientService.getAllClients(pageable);
        Page<ClientSimpleResponse> clientResponseDto = clients.map(ClientSimpleResponse::new);
        var totalPages = clientResponseDto.getTotalPages();
        return new ResponseEntity<>(
                RestResponse.responsePaginate(HttpStatus.OK, clientResponseDto.getContent(), new int[totalPages],
                        clientResponseDto.getNumber(), totalPages, clientResponseDto.getTotalElements(),
                        clientResponseDto.isFirst(), clientResponseDto.isLast(), "ClientSimpleResponse"),
                HttpStatus.OK);
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
    public ResponseEntity<Map<String, Object>> createClient(
            @Valid @RequestBody ClientSimpleCreate clientRequest,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(field -> errors.put(field.getField().toLowerCase(), field.getDefaultMessage()));
            return new ResponseEntity<>(RestResponse.response(HttpStatus.BAD_REQUEST, errors, "Map<String, String>"),
                    HttpStatus.BAD_REQUEST);
        }

        var clientEntity = clientRequest.toEntity();
        clientEntity = clientService.create(clientEntity);
        return new ResponseEntity<>(
                RestResponse.response(HttpStatus.CREATED, new ClientSimpleResponse(clientEntity),
                        "ClientSimpleResponse"),
                HttpStatus.CREATED);
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
