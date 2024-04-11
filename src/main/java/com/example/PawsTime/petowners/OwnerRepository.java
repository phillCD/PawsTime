package com.example.PawsTime.petowners;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import com.example.PawsTime.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long>, CustomQuerydslPredicateExecutor<Owner> {
}
