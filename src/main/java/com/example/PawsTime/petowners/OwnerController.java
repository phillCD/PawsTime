package com.example.PawsTime.petowners;

import com.example.PawsTime.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
@AllArgsConstructor
public class OwnerController {
    private OwnerService service;

    @GetMapping
    public ResponseEntity<List<OwnerRepresentation.OwnerResponse>> getAllOwners(){
        return ResponseEntity.ok(service.getAllOwners().stream().map(OwnerRepresentation.OwnerResponse::fromOwner).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<OwnerRepresentation.OwnerResponse> getOwnerById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(OwnerRepresentation.OwnerResponse.fromOwner(service.getOwnerById(id)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<OwnerRepresentation.OwnerResponse> createOwner(@RequestBody OwnerRepresentation.OwnerCreate owner){
        try{
            return ResponseEntity.ok().body(OwnerRepresentation.OwnerResponse.fromOwner(service.createOwner(owner)));
        } catch (NotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<OwnerRepresentation.OwnerResponse> updateOwner(@PathVariable Long id, @RequestBody OwnerRepresentation.OwnerUpdate owner){
        try{
            return ResponseEntity.ok().body(OwnerRepresentation.OwnerResponse.fromOwner(service.update(id, owner)));
        } catch (NotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<OwnerRepresentation.OwnerResponse> deleteOwner(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
