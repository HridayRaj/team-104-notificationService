package com.client.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.entity.MessageEntity;


@Repository
public interface MessageRepo extends JpaRepository<MessageEntity,Integer> {
	
}
