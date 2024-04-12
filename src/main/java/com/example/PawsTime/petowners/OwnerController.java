package com.example.PawsTime.petowners;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
public class OwnerController {
    private OwnerService service;

    @GetMapping
    public ResponseEntity<List<OwnerRepresentation.OwnerResponse>> getAllOwners(){
        return ResponseEntity.ok(service.getAllOwners().stream().map(OwnerRepresentation.OwnerResponse::fromOwner).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<OwnerRepresentation.OwnerResponse> getOwnerById(Long id){
        try{
            return ResponseEntity.ok(OwnerRepresentation.OwnerResponse.fromOwner(service.getOwnerById(id)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<OwnerRepresentation.OwnerResponse> updateOwner(@PathVariable Long id, @RequestBody OwnerRepresentation.OwnerUpdate owner){
        try{
            return ResponseEntity.ok().body(OwnerRepresentation.OwnerResponse.fromOwner(service.update(id, owner)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<OwnerRepresentation.OwnerResponse> deleteOwner(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
