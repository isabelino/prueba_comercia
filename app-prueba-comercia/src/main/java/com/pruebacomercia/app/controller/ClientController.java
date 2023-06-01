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
import com.pruebacomercia.app.entity.Client;
import com.pruebacomercia.app.service.ClientService;

@RestController
@RequestMapping("api")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	
	@GetMapping("/clients")
	public List<Client> index(){
		return clientService.allClients();
	}
	
	@PostMapping("/clients")
	public ResponseEntity<?> save(@RequestBody Client client) {
		Client clientNew = null;
		Map<String,Object> response = new HashMap<>();
		
		try {
			clientNew =  clientService.saveClient(client);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insert en base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		response.put("message","El cliente ha sido registrado con éxito!");
		response.put("client", clientNew);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
}
