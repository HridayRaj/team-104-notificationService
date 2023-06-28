package com.emailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.services.s3.internal.eventstreaming.Message;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.emailservice.MessagePayload;
import com.emailservice.reciever.SqsReciever;

@RestController
public class SnsController {


	public static final String TOPIC_ARN = "arn:aws:sns:us-east-1:946330802232:emailservice";

	@Autowired
	private AmazonSNSClient amazonSNSClient;
	private SqsReciever sqsReciever;
	
	//send msg from sns to sqs
	// @GetMapping("/subscribe/sqs")
	// public String subscribeToSQS() {
		
	// 	SubscribeRequest subscribeRequest= 
	// 			new SubscribeRequest(TOPIC_ARN, "sqs", "arn:aws:sqs:us-east-1:946330802232:dataqueue");
	// 	amazonSNSClient.subscribe(subscribeRequest);
	// 	return "user successfully subscribed";
	// }
	

	//subscribe to email service
	@PostMapping("/subscribe-email")
	public String subscribeToEmail(@RequestBody String email) {
		
		SubscribeRequest subscribeRequest= 
				new SubscribeRequest(TOPIC_ARN, "email", email);
		amazonSNSClient.subscribe(subscribeRequest);
		return "email successfully subscribed";
	}


	// publish email to user
	@PostMapping("/send-email")
	public String sendMessage(@RequestBody String message) {
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN,message,"email demo");
		amazonSNSClient.publish(publishRequest);
		
		
		return "Message published Successfully";
	}
	
	
}
