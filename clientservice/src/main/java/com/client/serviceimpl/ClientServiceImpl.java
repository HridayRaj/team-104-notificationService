package com.client.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.entity.ClientEntity;
import com.client.service.ClientService;
import com.client.Repository.*;


@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepo clientRepo;

	@Override
	public List<ClientEntity> getAllUser() {
		
		return clientRepo.findAll();

	}

    @Override
    public void saveAndPublish(ClientEntity entity) {

       
        //call smsservice 
        String subscribeUriForSms = "http://localhost:8082/subscribe-pnumber";

         //call email service
        String subscribeUriForEmail = "http://localhost:8080/subscribe-email";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(subscribeUriForSms, entity.getPhoneNumber(), String.class);
        ResponseEntity<String>s = restTemplate.postForEntity(subscribeUriForEmail, entity.getEmailId(), String.class);
        System.out.println(s);
        
        // save user to database
        clientRepo.save(entity);


       


       
    }

    




}
