package com.zmk.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zmk.domain.Pet;
import com.zmk.services.PetService;

@RestController
@CrossOrigin
@RequestMapping("/pet")
public class PetController {

	private PetService service;

	public PetController(PetService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Pet> createPet(@RequestBody Pet newPet) {
		return this.service.createPet(newPet);
	}

	@GetMapping("/get")
	public List<Pet> getPet() {
		return this.service.getPet();
	}

	@GetMapping("/get/{petId}")
	public ResponseEntity<Pet> getPet(@PathVariable Integer petId) {
		return this.service.getPet(petId);
	}

	@PatchMapping("/update/{petId}")
	public ResponseEntity<Pet> updatePet(@PathVariable Integer petId, @RequestBody Pet petDetails) {
		return this.service.updatePet(petId, petDetails);
	}

	@DeleteMapping("/delete/{petId}")
	public boolean deletePet(@PathVariable Integer petId) {
		return this.service.deletePet(petId);
	}

}