package com.client.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.entity.ClientEntity;

@Repository
public interface ClientRepo extends JpaRepository<ClientEntity,Integer>  {
	
	

}
