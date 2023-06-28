package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.client.entity.MessageEntity;
import com.client.service.HomeService;

@RestController
public class MessageController {
    
    @Autowired
    private HomeService homeService;

    @GetMapping("/message-controller")
    public String MessageController(){
        return "message controller working fine";
    }


    @PostMapping("/send-message")
    public String sendMessage(@RequestBody MessageEntity messageEntity){

        homeService.sendAndSaveMessage(messageEntity);

        return "message published successfully";
    }
}
