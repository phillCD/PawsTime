package com.example.PawsTime.schedule;

import com.example.PawsTime.petowners.OwnerRepresentation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("schedule")
@AllArgsConstructor
public class ScheduleController {
    private ScheduleService service;

    @GetMapping
    public ResponseEntity<List<ScheduleRepresentation.ScheduleResponse>> getAllSchedules(){
        return ResponseEntity.ok().body(service.getAllSchedules().stream().map(ScheduleRepresentation.ScheduleResponse::from).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ScheduleRepresentation.ScheduleResponse> getScheduleById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(ScheduleRepresentation.ScheduleResponse.from(service.getScheduleById(id)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("clinics/{clinicId}")
    public ResponseEntity<List<ScheduleRepresentation.ScheduleResponse>> getScheduleByClinicId(@PathVariable Long clinicId) {
        try {
            return ResponseEntity.ok(ScheduleRepresentation.ScheduleResponse.from(service.getSchedulesByClinicsId(clinicId)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ScheduleRepresentation.ScheduleResponse> createSchedule(@RequestBody ScheduleRepresentation.createSchedule schedule){
        return ResponseEntity.ok().body(ScheduleRepresentation.ScheduleResponse.from(service.createSchedule(schedule)));
    }

    @PostMapping("{id}")
    public ResponseEntity<ScheduleRepresentation.ScheduleResponse> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRepresentation.updateSchedule schedule){
        try{
            return ResponseEntity.ok().body(ScheduleRepresentation.ScheduleResponse.from(service.update(id, schedule)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ScheduleRepresentation.ScheduleResponse> deleteSchedule(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}