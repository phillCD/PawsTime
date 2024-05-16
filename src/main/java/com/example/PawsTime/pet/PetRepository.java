package com.example.PawsTime.pet;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long>, CustomQuerydslPredicateExecutor<Pet> {
}
