package com.pruebacomercia.app.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebacomercia.app.entity.Game;
import com.pruebacomercia.app.repository.GameRepository;
import com.pruebacomercia.app.service.GameService;
import com.pruebacomercia.app.utils.Utils;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	private GameRepository gameRepository;
	
	
	@Override
	@Transactional(readOnly= true)
	public List<Game> allGames() {
		return gameRepository.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Game findGameById(Long id) {
		return gameRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Game saveGame(Game game) {
		return gameRepository.save(game);
	}

	@Override
	@Transactional
	public void deleteGame(Long id) {
		gameRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly= true)
	public double calculateRentalPrice(Long id, int days) {
		Game game = findGameById(id);
		return (long) Utils.calculateprice(game, days);
	}



}
