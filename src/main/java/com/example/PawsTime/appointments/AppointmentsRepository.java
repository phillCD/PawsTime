package com.example.PawsTime.appointments;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, Long>, CustomQuerydslPredicateExecutor<Appointments> {
    List<Appointments> findByDateAndUserId(String date, Long userId);
}
