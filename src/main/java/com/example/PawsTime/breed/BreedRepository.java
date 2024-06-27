package com.example.PawsTime.breed;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import com.example.PawsTime.enums.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Long>, CustomQuerydslPredicateExecutor<Breed>{
    List<Breed> findByAnimal(Animals animal);
}
