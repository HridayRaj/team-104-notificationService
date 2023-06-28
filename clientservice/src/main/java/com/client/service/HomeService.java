package com.client.service;

import com.client.entity.MessageEntity;

public interface HomeService {

    void sendAndSaveMessage(MessageEntity messageEntity);
    
}
