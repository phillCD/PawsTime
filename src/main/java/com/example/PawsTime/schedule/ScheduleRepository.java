package com.example.PawsTime.schedule;

import com.example.PawsTime.appointments.Appointments;
import com.example.PawsTime.clinic.Clinic;
import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, CustomQuerydslPredicateExecutor<Schedule> {
}
