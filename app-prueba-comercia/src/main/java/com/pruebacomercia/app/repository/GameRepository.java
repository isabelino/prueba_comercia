package com.pruebacomercia.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pruebacomercia.app.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	//@Query(value = "SELECT price*?2 FROM Game u WHERE u.id = ?1", nativeQuery = true)
	//public long calculateRentalPrice(String name,int days);
}
