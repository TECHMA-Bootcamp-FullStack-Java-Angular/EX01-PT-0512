package com.dmb.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Message;
import com.dmb.repository.MessageDAO;
import com.dmb.sevices.interfaces.IMessageService;

@Service
public class MessageService implements IMessageService {

	@Autowired
	private MessageDAO dao;
	
	
	@Override
	public List<Message> getAllMessage() {
		return dao.findAll();
	}

	@Override
	public Optional<Message> getOneMessage(Long id) {
		return dao.findById(id);
	}

	@Override
	public Message createMessage(Message entity) {
		return dao.save(entity);
	}

	@Override
	public Message updateMessage(Message entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteMessage(Long id) {
		dao.findById(id);
	}

	@Override
	public List<Message> findMessagesByPartyId(Long partyId) {
		return dao.findMessagesByPartyId(partyId);
	}



}
