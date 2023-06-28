package com.emailservice.reciever;

import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SqsReciever {
	
	@SqsListener(value = "dataqueue" , deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
	public void recieve(String message) {
		System.out.println("here");
		log.info("Message revieved {}",message);
	}
}
