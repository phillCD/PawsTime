package com.example.PawsTime.pet;

import com.example.PawsTime.clinic.Clinic;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pet")
@AllArgsConstructor
public class PetController {
    private PetService service;

    @GetMapping
    public ResponseEntity<List<PetRepresentation.PetResponse>> getAllPets(){
        return ResponseEntity.ok(service.getAllPets().stream().map(PetRepresentation.PetResponse::from).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<PetRepresentation.PetResponse> getPetById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(PetRepresentation.PetResponse.from(service.getPetById(id)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("clinics/{id}")
    public ResponseEntity<List<PetRepresentation.PetResponse>> getPetByClinicsId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(PetRepresentation.PetResponse.from(service.getPetsByClinicsId(id)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<PetRepresentation.PetResponse> updatePet(@PathVariable Long id, @RequestBody PetRepresentation.updatePet pet){
        try{
            return ResponseEntity.ok().body(PetRepresentation.PetResponse.from(service.update(id, pet)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PetRepresentation.PetResponse> createPet(@RequestBody PetRepresentation.createPet pet){
        try{
            return ResponseEntity.ok().body(PetRepresentation.PetResponse.from(service.createPet(pet)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PetRepresentation.PetResponse> deletePet(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
