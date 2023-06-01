package com.pruebacomercia.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Game implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private String platform;
	
	@Column(nullable = false)
	private String game_genre;
	
	@Column(nullable = false)
	private String pgi;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date release_date;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
