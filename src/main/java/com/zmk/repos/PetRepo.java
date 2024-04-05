package com.zmk.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zmk.domain.Pet;

public interface PetRepo extends JpaRepository<Pet, Integer>{

}
