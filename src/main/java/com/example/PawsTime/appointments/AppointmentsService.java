package com.example.PawsTime.appointments;

import com.example.PawsTime.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    public List<Appointments> getAllAppointments() {
        return appointmentsRepository.findAll();
    }

    public Appointments getAppointmentsById(Long id) {
        return appointmentsRepository.findById(id).orElse(null);
    }

    public List<Appointments> getAppointmentsByDate(String date) {
        return appointmentsRepository.findByDate(date);
    }

    public Appointments createAppointments(AppointmentsRepresentation.createAppointments create) {
        return appointmentsRepository.save(new Appointments(
                create.getSchedule_id(),
                create.getUser_id(),
                create.getPet_id(),
                create.getProcedure(),
                create.getDate(),
                create.getHour(),
                create.getStatus()));
    }

    public Appointments update(Long id, AppointmentsRepresentation.updateAppointments entity) {
        var dbEntity = appointmentsRepository.findById(id).orElseThrow(() -> new NotFoundException("Appointments"));
        modelMapper.map(entity, dbEntity);

        return appointmentsRepository.save(dbEntity);
    }

    public Appointments delete(Long id) {
        var dbEntity = appointmentsRepository.findById(id).orElseThrow(() -> new NotFoundException("Appointments"));
        appointmentsRepository.delete(dbEntity);
        return dbEntity;
    }
}
