package com.smsservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer clientId;
	
	private String clientName;

	private String clientEmail;
	private String clientPhone;
}
