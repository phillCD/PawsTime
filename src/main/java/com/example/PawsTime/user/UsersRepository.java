package com.example.PawsTime.user;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>, CustomQuerydslPredicateExecutor<Users> {

    @Query("select u from Users u where u.login = ?1")
    Users findByUsername(String username);
}
