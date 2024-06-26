package com.example.PawsTime.schedule;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, CustomQuerydslPredicateExecutor<Schedule> {
}
