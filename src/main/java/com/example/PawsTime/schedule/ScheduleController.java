package com.example.PawsTime.schedule;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schedule")
public class ScheduleController {
    private ScheduleService service;

    @GetMapping
    public ResponseEntity<ScheduleRepresentation.ScheduleResponse> getAllSchedules(){
        return ResponseEntity.ok((ScheduleRepresentation.ScheduleResponse) service.getAllSchedules().stream().map(ScheduleRepresentation.ScheduleResponse::from).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ScheduleRepresentation.ScheduleResponse> getScheduleById(Long id){
        try{
            return ResponseEntity.ok(ScheduleRepresentation.ScheduleResponse.from(service.getScheduleById(id)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
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
