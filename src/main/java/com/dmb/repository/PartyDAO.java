package com.dmb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmb.entities.Party;


public interface PartyDAO extends JpaRepository<Party, Long> {

	public List<Party> findPartiesByGameId(Long gameId);

}
