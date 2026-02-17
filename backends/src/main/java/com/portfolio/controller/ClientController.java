package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.Client;
import com.portfolio.service.ClientService;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAllClients();
    }
}