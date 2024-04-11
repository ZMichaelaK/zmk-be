package com.zmk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zmk.domain.Pet;
import com.zmk.repos.PetRepo;


@Service
public class PetService {

    private PetRepo repo;

    public PetService(PetRepo repo) {
        super();
        this.repo = repo;
    }

    public ResponseEntity<Pet> createPet(Pet newPet) {
		Pet created = this.repo.save(newPet);
		return new ResponseEntity<Pet>(created, HttpStatus.CREATED);
	}

    public List<Pet> getPet() {
        return this.repo.findAll();
    }
    
    public ResponseEntity<Pet> getPet(Integer petId) {
        Optional<Pet> found = this.repo.findById(petId);

        if (found.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
		Pet body = found.get();

        return ResponseEntity.ok(body);
    }

    public ResponseEntity<Pet> updatePet(Integer petId, Pet petDetails) {
        Optional<Pet> found = this.repo.findById(petId);

        if (found.isEmpty()) {
            return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
        }

        Pet existing = found.get();

        if (petDetails.getPetName() != null) {
            existing.setPetName(petDetails.getPetName());
        }
        if (petDetails.getPetAge() != null) {
            existing.setPetAge(petDetails.getPetAge());
        }
        if (petDetails.getPetType() != null) {
            existing.setPetType(petDetails.getPetType());
        }
        if (petDetails.getPetColour() != null) {
            existing.setPetColour(petDetails.getPetColour());
        }
        if (petDetails.getImage() != null) {
            existing.setImage(petDetails.getImage());
        }

        Pet updated = this.repo.save(existing);

        return ResponseEntity.ok(updated);
    }

    public boolean deletePet(Integer petId) {
        this.repo.deleteById(petId);

        return !this.repo.existsById(petId);
    }
}
