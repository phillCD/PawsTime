package com.example.PawsTime.clinic;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clinic")
@AllArgsConstructor
public class ClinicController {

    private ClinicService service;

    @GetMapping
    public List<ClinicRepresentation.clinicResponse> getAllClinics(){
        return service.getAllClinics().stream().map(ClinicRepresentation.clinicResponse::from).toList();
    }

    @GetMapping("{id}")
    public ClinicRepresentation.clinicResponse getClinicById(@PathVariable Long id){
        return ClinicRepresentation.clinicResponse.from(service.getClinicById(id));
    }

    @PostMapping
    public ResponseEntity<ClinicRepresentation.clinicResponse> createClinic(@RequestBody ClinicRepresentation.createClinic clinic){
        return ResponseEntity.ok().body(ClinicRepresentation.clinicResponse.from(service.createClinic(clinic)));
    }

    @PostMapping("{id}")
    public ClinicRepresentation.clinicResponse updateClinic(@PathVariable Long id, @RequestBody ClinicRepresentation.updateClinic clinic){
        return ClinicRepresentation.clinicResponse.from(service.update(id, clinic));
    }

    @DeleteMapping("{id}")
    public ClinicRepresentation.clinicResponse deleteClinic(@PathVariable Long id){
        return ClinicRepresentation.clinicResponse.from(service.delete(id));
    }
}
