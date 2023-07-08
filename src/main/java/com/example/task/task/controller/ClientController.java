package com.example.task.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.task.entity.Client;
import com.example.task.task.service.ClientService;

@RestController
public class ClientController {
    
    @Autowired
	private ClientService clientService;

    @PostMapping("/saveClient") 
	public ResponseEntity<Client> saveClient(@RequestBody Client client)
	{
	    return clientService.addClient(client);
	}

    @GetMapping(value="/client")
	public  ResponseEntity<List<Client>> getAllClient() {
	    return clientService.getAllClient();
	}

    @GetMapping("/client/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable int id) { 
	    return clientService.getById(id);
	}

    @PutMapping("/client/{id}")
	public void updateClient(@PathVariable int id, @RequestBody Client client) {
	    clientService.updateClient(id, client);
	}

	@DeleteMapping("/client/{id}")
	public void deleteClient(@PathVariable int id) {
	    clientService.deleteById(id);
	}


}
