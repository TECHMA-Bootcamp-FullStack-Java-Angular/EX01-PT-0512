package com.dmb.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Party_Member;

@Repository
public interface Party_MemberDAO extends JpaRepository<Party_Member, Long> {

	public List<Party_Member> findUsersByPartyId(Long partyId);
	
	public List<Party_Member> findPartiesByUserId(Long userId);

}
