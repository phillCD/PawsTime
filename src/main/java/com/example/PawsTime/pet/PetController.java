package com.example.PawsTime.pet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pet")
public class PetController {
    private PetService service;

    @GetMapping
    public ResponseEntity<PetRepresentation.PetResponse> getAllPets(){
        return ResponseEntity.ok((PetRepresentation.PetResponse) service.getAllPets().stream().map(PetRepresentation.PetResponse::from).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<PetRepresentation.PetResponse> getPetById(Long id){
        try{
            return ResponseEntity.ok(PetRepresentation.PetResponse.from(service.getPetById(id)));
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

    @DeleteMapping("{id}")
    public ResponseEntity<PetRepresentation.PetResponse> deletePet(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
