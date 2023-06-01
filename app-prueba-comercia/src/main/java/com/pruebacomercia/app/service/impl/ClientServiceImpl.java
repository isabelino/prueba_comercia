package com.pruebacomercia.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebacomercia.app.entity.Client;
import com.pruebacomercia.app.repository.ClientRepository;
import com.pruebacomercia.app.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	@Transactional(readOnly= true)
	public List<Client> allClients() {
		return clientRepository.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Client findClientById(Long id) {
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	@Transactional
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
		
	}

}
