package com.dmb.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmb.entities.Message;
import com.dmb.sevices.MessageService;

@RestController 
@RequestMapping("/api/v1")
public class MessageController {

	
	@Autowired
	private MessageService messageService;

	@GetMapping("/messages")
	public ResponseEntity<List<Message>> getAllMessage() {
		return ResponseEntity.ok(messageService.getAllMessage());
	}
	
	@PostMapping("/message")
	public ResponseEntity<Message> saveMessage(@RequestBody Message entity) {
		return ResponseEntity.ok(messageService.createMessage(entity));
	}
	
	@PutMapping("/message/{id}/{name}")
	public ResponseEntity<?> updateMessage(@PathVariable(name = "id") Long id,
			@PathVariable(name = "name") String name , @RequestBody Message entity) {
		Optional<Message> entityOld = messageService.getOneMessage(id);
		if (entityOld.isPresent()) {
			
			if (entityOld.get().getSender().getUsername().equals(name)) {
			   return ResponseEntity.ok(messageService.updateMessage(entity));
			}
			return ResponseEntity.status(403)
					.body(Map.of("Attention ", "You do not have access to this record because you are not the owner of it."));	
		} else {
			return ResponseEntity.status(404)
					.body(Map.of("Error ", "The message " + id + " not exists"));
		}
	}
	
	@DeleteMapping("/message/{id}/{name}")
	public ResponseEntity<Void> deleteMessage(@PathVariable(name = "id") Long id , @PathVariable(name = "name") String name ) {
		Optional<Message> entity = messageService.getOneMessage(id);
		if (entity.isPresent()) {
			if (entity.get().getSender().getUsername().equals(name)) {
				  messageService.deleteMessage(id);
				}		
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
