package com.smsservice.payload;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageBody {
	
	private String[] to;
	private String subject;
	private String body;
	
}
