package com.dmb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmb.entities.Party_Member;
import com.dmb.sevices.Party_MemberService;


@RestController 
@RequestMapping("/api/v1")
public class Party_MemberController {

	@Autowired
	private Party_MemberService party_MemberServ;
	
//	@GetMapping("/party_members")
//	public ResponseEntity<List<Party_Member>> getAllParty_Member() {
//		return ResponseEntity.ok(party_MemberServ.getAllParty_Member());
//	}
//	
//	@GetMapping("/party_member/{id}")
//	public ResponseEntity<Party_Member> getOneParty_Member(@PathVariable(name = "id") Long id) {
//		Optional<Party_Member> entity = party_MemberServ.getOneParty_Member(id);
//		if (entity.isPresent()) {
//			return ResponseEntity.ok(entity.get());
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
//	
	@PostMapping("/party_member")
	public ResponseEntity<Party_Member> saveParty_Member(@RequestBody Party_Member entity) {
		return ResponseEntity.ok(party_MemberServ.createParty_Member(entity));
	}
	
//	@PutMapping("/party_member/{id}")
//	public ResponseEntity<Party_Member> updateParty_Member(@PathVariable(name = "id") Long id, @RequestBody Party_Member entity) {
//		Optional<Party_Member> entityOld = party_MemberServ.getOneParty_Member(id);
//
//		if (entityOld.isPresent()) {
//			return ResponseEntity.ok(party_MemberServ.updateParty_Member(entity));
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
	
	@DeleteMapping("/party_member/{id}")
	public ResponseEntity<Void> deleteParty_Member(@PathVariable(name = "id") Long id) { 
		Optional<Party_Member> entity = party_MemberServ.getOneParty_Member(id);
		if (entity.isPresent()) {
			party_MemberServ.deleteParty_Member(id);
			return ResponseEntity.noContent().build();
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
