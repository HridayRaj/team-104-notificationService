package com.client.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.Repository.MessageRepo;
import com.client.entity.MessageEntity;
import com.client.service.HomeService;


@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private MessageRepo messageRepo;
    
    

    @Override
    public void sendAndSaveMessage(MessageEntity messageEntity) {
        

        String finalMessage = messageEntity.getSubject() +"\n" + messageEntity.getMessageBody();


        // call sms service
        String smsUri = "http://localhost:8082/publishsms";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(smsUri, finalMessage, String.class);

        // call to email service
        String emailUri = "http://localhost:8080/send-email";

        restTemplate.postForEntity(emailUri, finalMessage, String.class);

        
        // save message to database
        messageRepo.save(messageEntity);

    }
    
    
}
