package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Game;

@Repository
public interface GameDAO extends JpaRepository<Game, Long> {

}
