package com.example.PawsTime.appointments;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentsRepository extends JpaRepository<Appointments, Long>, CustomQuerydslPredicateExecutor<Appointments> {
}
