package com.pruebacomercia.app.service;

import java.util.List;


import com.pruebacomercia.app.entity.Rent;

public interface RentService {
	
	public List<Rent> allRents();
	
	public Rent findRentById(Long id);
	
	public Rent saveRent(Rent rent);
	

}
