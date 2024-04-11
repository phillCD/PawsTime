package com.example.PawsTime.schedule;

import com.example.PawsTime.core.CustomQuerydslPredicateExecutor;
import com.example.PawsTime.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, CustomQuerydslPredicateExecutor<Schedule> {
}
