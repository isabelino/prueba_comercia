package com.pruebacomercia.app.utils;

import com.pruebacomercia.app.entity.Game;

public class Utils {

	public static double calculateprice(Game game,int days) {
	    double value = 0;
		if(game.getType().equals("nuevo")) {
			value =  days > 3 ? (double) Constants.PREMIUM_PRICE+(double) (Constants.PREMIUM_PRICE*(days-3)) :(double) Constants.PREMIUM_PRICE;
		}else if(game.getType().equals("estandar")) {
			value =  days > 3 ? (double) Constants.BASE_PRICE+(double) (Constants.BASE_PRICE*(days-3)) :(double) Constants.BASE_PRICE;
		}else {
			value =  days > 5 ? (double) Constants.BASE_PRICE+(double) (Constants.BASE_PRICE*(days-5)) :(double) Constants.BASE_PRICE;
		}
		return value;
	}
}
