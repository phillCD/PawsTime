package com.example.PawsTime.breed;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("breed")
@AllArgsConstructor
public class BreedController {

    private BreedService service;

    @GetMapping
    public ResponseEntity<List<BreedRepresentation.breedResponse>> getAllBreeds(){
        return ResponseEntity.ok(service.getAllBreeds().stream().map(BreedRepresentation.breedResponse::fromBreed).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<BreedRepresentation.breedResponse> getBreedById(Long id){
        try{
            return ResponseEntity.ok(BreedRepresentation.breedResponse.fromBreed(service.getBreedById(id)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BreedRepresentation.breedResponse> createBreed(BreedRepresentation.createBreed breed){
        try{
            return ResponseEntity.ok().body(BreedRepresentation.breedResponse.fromBreed(service.createBreed(breed)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<BreedRepresentation.breedResponse> updateBreed(Long id, BreedRepresentation.updateBreed breed){
        try{
            return ResponseEntity.ok().body(BreedRepresentation.breedResponse.fromBreed(service.update(id, breed)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BreedRepresentation.breedResponse> deleteBreed(Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
