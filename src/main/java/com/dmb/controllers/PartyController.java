package com.dmb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmb.entities.Party;
import com.dmb.sevices.PartyService;

@RestController // Rest controller
@RequestMapping("/api/v1")
public class PartyController {

	@Autowired
	private PartyService partyServ;
	
//	@GetMapping("/parties")
//	public ResponseEntity<List<Party>> getAllParty() {
//		return ResponseEntity.ok(partyServ.getAllParty());
//	}
	
	@GetMapping("/party/{id}")
	public ResponseEntity<Party> getOneParty(@PathVariable(name = "id") Long id) {
		Optional<Party> entity = partyServ.getOneParty(id);
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
//	@PostMapping("/party")
//	public ResponseEntity<Party> saveParty(@RequestBody Party entity) {
//		return ResponseEntity.ok(partyServ.createParty(entity));
//	}
	
	// CAMBIAR BUSCAR POR NOMBRE VIDEOJUEG
	@PutMapping("/party/{id}")
	public ResponseEntity<Party> updateParty(@PathVariable(name = "id") Long id, @RequestBody Party entity) {
		Optional<Party> entityOld = partyServ.getOneParty(id);

		if (entityOld.isPresent()) {
			return ResponseEntity.ok(partyServ.updateParty(entity));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
//	@DeleteMapping("/party/{id}")
//	public ResponseEntity<Void> deleteParty(@PathVariable(name = "id") Long id) { 
//		Optional<Party> entity = partyServ.getOneParty(id);
//		if (entity.isPresent()) {
//			partyServ.deleteParty(id);
//			return ResponseEntity.noContent().build();
//			
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}

}
