package com.example.PawsTime.enchiridion;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnchiridionRepository extends JpaRepository<Enchiridion, Long>, CustomQuerydslPredicateExecutor<Enchiridion> {
}
