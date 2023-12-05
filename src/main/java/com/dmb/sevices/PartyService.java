package com.dmb.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Party;
import com.dmb.repository.PartyDAO;
import com.dmb.sevices.interfaces.IPartyService;

@Service
public class PartyService implements IPartyService{

	@Autowired
	private PartyDAO dao;
	
	@Override
	public List<Party> getAllParty() {
		return dao.findAll();
	}

	@Override
	public Optional<Party> getOneParty(Long id) {
		return dao.findById(id);
	}

	@Override
	public Party createParty(Party entity) {
		return dao.save(entity);
	}

	@Override
	public Party updateParty(Party entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteParty(Long id) {
		dao.deleteById(id);		
	}

	@Override
	public List<Party> findPartiesByGameId(Long gameId) {
		return dao.findPartiesByGameId(gameId);
	}
	

}
