package com.pruebacomercia.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebacomercia.app.entity.LoyaltyPoint;
import com.pruebacomercia.app.entity.Rent;
import com.pruebacomercia.app.service.RentService;
import com.pruebacomercia.app.service.impl.LoyaltyPointService;

@RestController
@RequestMapping("api")
public class RentController {
	
	@Autowired
	private RentService gameService;
	
	@Autowired
	private LoyaltyPointService loyaltyPointService;
	
	@GetMapping("/rents")
	public List<Rent> index(){
		return gameService.allRents();
	}
	
	@PostMapping("/rents")
	public ResponseEntity<?> save(@RequestBody Rent rent) {
		Rent gameRent = null;
		LoyaltyPoint loyaltyPoint=null;
		Map<String,Object> response = new HashMap<>();
		
		try {
			gameRent =  gameService.saveRent(rent);
			
			if(rent.getGame().getType().equals("nuevo")) {
				loyaltyPoint = new LoyaltyPoint();
				loyaltyPoint.setClient(rent.getClient());
				loyaltyPoint.setAccumulated_points(2);
				
				loyaltyPointService.saveLoyaltyPoint(loyaltyPoint);
			}else {
				loyaltyPoint = new LoyaltyPoint();
				loyaltyPoint.setClient(rent.getClient());
				loyaltyPoint.setAccumulated_points(1);
				loyaltyPointService.saveLoyaltyPoint(loyaltyPoint);
			}
			
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insert en base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		response.put("message","El alquiler ha sido registrado con éxito!");
		response.put("game", gameRent);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}

}
