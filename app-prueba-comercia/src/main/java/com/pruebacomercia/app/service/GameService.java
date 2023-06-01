package com.pruebacomercia.app.service;

import java.util.List;


import com.pruebacomercia.app.entity.Game;

public interface GameService {

	
	public List<Game> allGames();
	
	public Game findGameById(Long id);
	
	public Game saveGame(Game game);
	
	public void deleteGame(Long id);
	
	public double calculateRentalPrice(Long id, int days);


}
