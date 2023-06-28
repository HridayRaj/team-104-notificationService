package com.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.entity.ClientEntity;
import com.client.service.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ClientController {
	
    @Autowired
    private ClientService clientService;



    @GetMapping("/")
    List<ClientEntity> getAllUser(){
        return clientService.getAllUser();
    }

    @PostMapping("/create-entity")
    public String postMethodName(@RequestBody ClientEntity entity) {
        
        clientService.saveAndPublish(entity);
        return "user created successfully";
    }
    
}
