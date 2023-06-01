package com.pruebacomercia.app.service;

import java.util.List;

import com.pruebacomercia.app.entity.Client;

public interface ClientService {

	public List<Client> allClients();
	
	public Client findClientById(Long id);
	
	public Client saveClient(Client client);
	
	public void deleteClient(Long id);

}
