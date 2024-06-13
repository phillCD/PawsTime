package com.example.PawsTime.breed;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Long>, CustomQuerydslPredicateExecutor<Breed>{

}
