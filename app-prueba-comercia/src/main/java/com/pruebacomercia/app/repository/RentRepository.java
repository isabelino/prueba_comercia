package com.pruebacomercia.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebacomercia.app.entity.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long>{

}
