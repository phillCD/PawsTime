package com.example.PawsTime.petowners;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long>, CustomQuerydslPredicateExecutor<Owner> {
}
