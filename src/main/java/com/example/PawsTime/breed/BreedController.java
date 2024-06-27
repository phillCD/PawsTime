package com.example.PawsTime.breed;

import com.example.PawsTime.enums.Animals;
import com.example.PawsTime.exceptions.NotFoundException;
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
    public ResponseEntity<BreedRepresentation.breedResponse> getBreedById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(BreedRepresentation.breedResponse.fromBreed(service.getBreedById(id)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/animal/{animal}")
    public ResponseEntity<List<BreedRepresentation.breedResponse>> getBreedsByAnimal(@PathVariable Animals animal){
        return ResponseEntity.ok(service.getBreedsByAnimal(animal).stream().map(BreedRepresentation.breedResponse::fromBreed).toList());
    }

    @PostMapping
    public ResponseEntity<BreedRepresentation.breedResponse> createBreed(@RequestBody BreedRepresentation.createBreed breed){
        try{
            return ResponseEntity.ok().body(BreedRepresentation.breedResponse.fromBreed(service.createBreed(breed)));
        } catch (NotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<BreedRepresentation.breedResponse> updateBreed(@PathVariable Long id,@RequestBody BreedRepresentation.updateBreed breed){
        try{
            return ResponseEntity.ok().body(BreedRepresentation.breedResponse.fromBreed(service.update(id, breed)));
        } catch (NotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BreedRepresentation.breedResponse> deleteBreed(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
