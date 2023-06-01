package com.pruebacomercia.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebacomercia.app.entity.LoyaltyPoint;
import com.pruebacomercia.app.repository.LoyaltyPointRepository;

@Service
public class LoyaltyPointService implements com.pruebacomercia.app.service.LoyaltyPointService{

	@Autowired
	private LoyaltyPointRepository loyaltyPointRepository;
	
	
	@Override
	@Transactional(readOnly= true)
	public LoyaltyPoint findLoyaltyPointById(Long id) {
		return loyaltyPointRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public LoyaltyPoint saveLoyaltyPoint(LoyaltyPoint loyaltyPoint) {
		return loyaltyPointRepository.save(loyaltyPoint);
	}

}
