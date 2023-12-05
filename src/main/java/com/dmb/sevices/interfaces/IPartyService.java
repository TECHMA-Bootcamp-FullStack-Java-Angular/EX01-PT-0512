package com.dmb.sevices.interfaces;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Party;

public interface IPartyService {
	
	//CRUD 

	//Read All
	public List<Party> getAllParty();

	//Read One
	public Optional<Party> getOneParty(Long id);

	public Party createParty(Party entity);

	//Update
	public Party updateParty(Party entity);

	//Delete
	public void deleteParty(Long id);
	
	//Finds and returns a list of parties associated with a specific game.
	public List<Party> findPartiesByGameId(Long gameId);
	
	
}
