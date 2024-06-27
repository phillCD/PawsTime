package com.example.PawsTime.user;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>, CustomQuerydslPredicateExecutor<Users> {
    Users findByLogin(String login);
    @Query("select u from Users u where u.login = ?1")
    Users findByUsername(String username);
}
