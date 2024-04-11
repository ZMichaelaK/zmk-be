package com.zmk.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer petId;
	private String petName;
	private Integer petAge;
	private String petColour;
	private String petURL;
	
	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Integer getPetAge() {
		return petAge;
	}

	public void setPetAge(Integer petAge) {
		this.petAge = petAge;
	}

	public String getPetColour() {
		return petColour;
	}

	public void setPetColour(String petColour) {
		this.petColour = petColour;
	}

	public String getPetURL() {
		return petURL;
	}

	public void setPetURL(String petURL) {
		this.petURL = petURL;
	}
	}