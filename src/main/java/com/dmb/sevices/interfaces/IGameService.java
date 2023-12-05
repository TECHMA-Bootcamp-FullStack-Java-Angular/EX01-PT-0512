package com.dmb.sevices.interfaces;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Game;

public interface IGameService {
	
	//CRUD 

	//Read All
	public List<Game> getAllGame();

	//Read One
	public Optional<Game> getOneGame(Long id); 
	//Create

	public Game createGame(Game entity);

	//Update
	public Game updateGame(Game entity);

	//Delete
	public void deleteGame(Long id); 
	
	

}
