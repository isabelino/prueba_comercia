package com.pruebacomercia.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebacomercia.app.entity.Rent;
import com.pruebacomercia.app.repository.RentRepository;
import com.pruebacomercia.app.service.RentService;

@Service
public class RentServiceImpl implements RentService{

	@Autowired
	private RentRepository rentRepository;
	
	@Override
	@Transactional(readOnly= true)
	public List<Rent> allRents() {
		return rentRepository.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Rent findRentById(Long id) {
		return rentRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Rent saveRent(Rent rent) {
		return rentRepository.save(rent);
	}

}
