package com.dmb.sevices.interfaces;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Party_Member;

public interface IParty_MemberService {
	
	//CRUD 

	//Read All
	public List<Party_Member> getAllParty_Member();

	//Read One
	public Optional<Party_Member> getOneParty_Member(Long id); 
	//Create

	public Party_Member createParty_Member(Party_Member entity);

	//Update
	public Party_Member updateParty_Member(Party_Member entity);

	//Delete
	public void deleteParty_Member(Long id);
	
	//Finds and returns a list of party members associated with a given party ID.
	public List<Party_Member> findUsersByPartyId(Long partyId);
	
	//Searches and returns a list of matches associated with a given user ID.
	public List<Party_Member> findPartiesByUserId(Long userId);

}
