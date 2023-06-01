package com.pruebacomercia.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@Column(nullable = false)
	public String name;
	@Column(nullable = false)
	public String last_name;
	@Column(nullable = false)
	public String email;
	@Column(nullable = false)
	public String phone;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@PrePersist
	public void prePresist() {
		createdAt = new Date();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
