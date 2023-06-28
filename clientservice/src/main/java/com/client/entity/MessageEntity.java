package com.client.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer messageId;
	private String Subject;
	private String messageBody;
	
	

	
}
