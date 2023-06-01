package com.pruebacomercia.app.service;

import com.pruebacomercia.app.entity.LoyaltyPoint;


public interface LoyaltyPointService {

    public LoyaltyPoint findLoyaltyPointById(Long id);
	
	public LoyaltyPoint saveLoyaltyPoint(LoyaltyPoint loyaltyPoint);
}
