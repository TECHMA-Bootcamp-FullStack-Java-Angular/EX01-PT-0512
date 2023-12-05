package com.dmb.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Party_Member;
import com.dmb.repository.Party_MemberDAO;
import com.dmb.sevices.interfaces.IParty_MemberService;

@Service
public class Party_MemberService implements IParty_MemberService {

	@Autowired
	private Party_MemberDAO dao;
	
	@Override
	public List<Party_Member> getAllParty_Member() {
		return dao.findAll();
	}

	@Override
	public Optional<Party_Member> getOneParty_Member(Long id) {
		return dao.findById(id);
	}

	@Override
	public Party_Member createParty_Member(Party_Member entity) {	
		return dao.save(entity);
	}

	@Override
	public Party_Member updateParty_Member(Party_Member entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteParty_Member(Long id) {
		dao.deleteById(id);
	}

	@Override
	public List<Party_Member> findUsersByPartyId(Long partyId) {
		return dao.findUsersByPartyId(partyId);
	}

	@Override
	public List<Party_Member> findPartiesByUserId(Long userId) {
		return dao.findPartiesByUserId(userId);
	}

}
