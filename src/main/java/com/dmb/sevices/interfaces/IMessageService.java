package com.dmb.sevices.interfaces;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Message;

public interface IMessageService {
	//CRUD 

	//Read All
	public List<Message> getAllMessage();

	//Read One
	public Optional<Message> getOneMessage(Long id);
	//Create

	public Message createMessage(Message entity);

	//Update
	public Message updateMessage(Message entity);

	//Delete
	public void deleteMessage(Long id); 
	
	// Finds and returns a list of party members associated with a specific user
	public List<Message> findMessagesByPartyId(Long partyId);
}
