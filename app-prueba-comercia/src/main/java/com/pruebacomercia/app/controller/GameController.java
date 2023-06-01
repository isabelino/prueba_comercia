package com.pruebacomercia.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebacomercia.app.entity.Game;
import com.pruebacomercia.app.service.GameService;

@RestController
@RequestMapping("api")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping("/games")
	public List<Game> index(){
		return gameService.allGames();
	}
	
	@GetMapping("/gameprices/{id}/days/{day}")
	public double pricesSearch(@PathVariable Long id, @PathVariable int day){
		return gameService.calculateRentalPrice(id, day);
	}
	
	@PostMapping("/games")
	public ResponseEntity<?> save(@RequestBody Game game) {
		Game gameNew = null;
		Map<String,Object> response = new HashMap<>();
		
		try {
			gameNew =  gameService.saveGame(game);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insert en base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		response.put("message","El juego ha sido registrado con éxito!");
		response.put("game", gameNew);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
}
