package com.example.task.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.task.task.entity.Client;
import com.example.task.task.exception.CustomException;

import java.util.List;
import java.util.Optional;

import com.example.task.task.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepo;

    // Get All Client data
    public ResponseEntity<List<Client>> getAllClient()
	{
		try
		{
            List<Client> list=(List<Client>)this.clientRepo.findAll();
            return ResponseEntity.ok(list) ;
		}
		catch (Exception e)
		{
            throw new CustomException(" Empty Dataset "+e.toString());
		}
	}

    // Get Client Data Base On Id
    public ResponseEntity<Client> getById(int cid)
	{
		Client client=null;
		try {
			client=this.clientRepo.findById(cid).orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + cid));
;
			return ResponseEntity.ok(client);
		}
		catch(Exception e)
		{
			throw new CustomException(" Id Not Found "+e.toString());
		}
	}

    // Save Client Data 
    public ResponseEntity<Client> addClient(Client c)
	{
		try {
            Client client=this.clientRepo.save(c);
            return ResponseEntity.ok(client);
		}
        catch(Exception e)
		{
			throw new CustomException(" Something Wrong "+e.toString());
		}
	}

    // Delete Data
    public String deleteById(int id) {
		Optional<Client> clinOptional = clientRepo.findById(id);
		
		if(clinOptional.isPresent())
		{
			clientRepo.deleteById(id);
			return "Record deleted successfully!!";
		}
		else
		{
			throw new CustomException(" Id Not Found "+id);
		}
	}

    public ResponseEntity<Client> updateClient(int id, Client client) {
		Client existClient = clientRepo.findById(id).orElseThrow(()->
		new CustomException(" Id Not Found "+id));

        existClient.setName(client.getName());
        existClient.setEmail(client.getEmail());
        existClient.setPhone(client.getPhone());

        clientRepo.save(existClient);
        return ResponseEntity.ok(existClient);
        
    }
    
}
