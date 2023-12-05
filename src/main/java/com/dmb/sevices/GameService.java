package com.dmb.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Game;
import com.dmb.repository.GameDAO;
import com.dmb.sevices.interfaces.IGameService;

@Service
public class GameService implements IGameService{
	
	@Autowired
	private GameDAO dao;

	@Override
	public List<Game> getAllGame() {
		return dao.findAll();
	}

	@Override
	public Optional<Game> getOneGame(Long id) {
		return dao.findById(id);
	}

	@Override
	public Game createGame(Game entity) {
		return dao.save(entity);
	}

	@Override
	public Game updateGame(Game entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteGame(Long id) {
		dao.deleteById(id);
	}

}
