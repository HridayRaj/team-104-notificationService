package com.smsservice.controller;


import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.smsservice.payload.MessageBody;


import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	public static final String TOPIC_ARN = "arn:aws:sns:us-east-1:946330802232:emailservice";
    
    
    
    @Autowired
    private AmazonSNSClient amazonSNSClient;
    
	@GetMapping("/")
	public String smsService() {
		return "sms service working fine";
	}
	
	@PostMapping("/subscribe-pnumber")
	public String subscribe(@RequestBody String phoneNumeber) {
		
		SubscribeRequest subscribeRequest = new SubscribeRequest(TOPIC_ARN,"sms", phoneNumeber);
		amazonSNSClient.subscribe(subscribeRequest);
		return "phone number successfully subscribed";
	}
	
	@PostMapping("/publishsms")
	public String sendMessage(@RequestBody String message) {
		HashMap<String, String> attributes = new HashMap<>(1);
        attributes.put("DefaultSMSType", "Transactional");
        attributes.put("UsageReportS3Bucket", "janbucket" );
        
		PublishRequest publishRequest = new PublishRequest();
		publishRequest.setMessage(message);
		//publishRequest.setTopicArn(TOPIC_ARN);
		publishRequest.setPhoneNumber("+919110041083");
		publishRequest.setMessageAttributes(null);
		amazonSNSClient.publish(publishRequest);
		return "message successfully published";
	}
	
	
	
	
}
