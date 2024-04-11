package com.example.PawsTime.schedule;

import com.example.PawsTime.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService {
    private ModelMapper modelMapper;
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    public Schedule createSchedule(ScheduleRepresentation.createSchedule create) {
        return scheduleRepository.save(new Schedule(
                create.getUser_id(),
                create.getClinic_id(),
                create.getDate_start(),
                create.getDate_finish(),
                create.getHour_start(),
                create.getHour_finish(),
                create.getHorary(),
                create.getDuration()
        ));
    }

    public Schedule update(Long id, ScheduleRepresentation.updateSchedule entity) {
        var dbEntity = scheduleRepository.findById(id).orElseThrow(() -> new NotFoundException("Schedule"));
        modelMapper.map(entity, dbEntity);

        return scheduleRepository.save(dbEntity);
    }

    public Schedule delete(Long id) {
        var dbEntity = scheduleRepository.findById(id).orElseThrow(() -> new NotFoundException("Schedule"));
        scheduleRepository.delete(dbEntity);
        return dbEntity;
    }
}
