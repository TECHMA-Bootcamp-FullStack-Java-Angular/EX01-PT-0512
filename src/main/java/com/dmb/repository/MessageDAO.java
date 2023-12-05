package com.dmb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Message;


@Repository
public interface MessageDAO extends JpaRepository<Message, Long> {

	public List<Message> findMessagesByPartyId(Long partyId);

}
