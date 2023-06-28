package com.client.service;

import java.util.List;

import com.client.entity.ClientEntity;

public interface ClientService {

	List<ClientEntity> getAllUser();

	void saveAndPublish(ClientEntity entity);
	
}
