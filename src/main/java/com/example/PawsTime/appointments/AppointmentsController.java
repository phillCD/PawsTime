package com.example.PawsTime.appointments;

import com.example.PawsTime.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointments")
@AllArgsConstructor
public class AppointmentsController {

    private AppointmentsService service;

    @GetMapping
    public ResponseEntity<List<AppointmentsRepresentation.appointmentsResponse>> getAllAppointments(){
        return ResponseEntity.ok(service.getAllAppointments().stream().map(AppointmentsRepresentation.appointmentsResponse::fromAppointments).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<AppointmentsRepresentation.appointmentsResponse> getAppointmentsById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(AppointmentsRepresentation.appointmentsResponse.fromAppointments(service.getAppointmentsById(id)));
        } catch (NotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/date/{date}/user/{userId}")
    public ResponseEntity<List<AppointmentsRepresentation.appointmentsResponse>> getAppointmentsByDateAndUserId(@PathVariable String date, Long userId){
        try{
            return ResponseEntity.ok(AppointmentsRepresentation.appointmentsResponse.fromAppointments(service.getAppointmentsByDateAndUserId(date, userId)));
        } catch (NotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<AppointmentsRepresentation.appointmentsResponse> createAppointments(@RequestBody AppointmentsRepresentation.createAppointments appointments){
        try{
            return ResponseEntity.ok().body(AppointmentsRepresentation.appointmentsResponse.fromAppointments(service.createAppointments(appointments)));
        } catch (NotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<AppointmentsRepresentation.appointmentsResponse> updateAppointments(@PathVariable Long id, @RequestBody AppointmentsRepresentation.updateAppointments appointments){
        try{
            return ResponseEntity.ok().body(AppointmentsRepresentation.appointmentsResponse.fromAppointments(service.update(id, appointments)));
        } catch (NotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AppointmentsRepresentation.appointmentsResponse> deleteAppointments(Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
