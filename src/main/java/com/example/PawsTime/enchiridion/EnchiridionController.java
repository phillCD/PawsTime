package com.example.PawsTime.enchiridion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enchiridion")
public class EnchiridionController {
    private EnchiridionService service;

    @GetMapping
    public ResponseEntity<EnchiridionRepresentation.enchiridionResponse> getAllEnchiridions(){
        return ResponseEntity.ok((EnchiridionRepresentation.enchiridionResponse) service.getAllEnchiridions().stream().map(EnchiridionRepresentation.enchiridionResponse::fromEnchiridion).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<EnchiridionRepresentation.enchiridionResponse> getEnchiridionById(Long id){
        try{
            return ResponseEntity.ok(EnchiridionRepresentation.enchiridionResponse.fromEnchiridion(service.getEnchiridionById(id)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EnchiridionRepresentation.enchiridionResponse> createEnchiridion(@RequestBody EnchiridionRepresentation.updateEnchiridion enchiridion){
        try{
            return ResponseEntity.ok().body(EnchiridionRepresentation.enchiridionResponse.fromEnchiridion(service.createEnchiridion(enchiridion)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<EnchiridionRepresentation.enchiridionResponse> updateEnchiridion(@PathVariable Long id, @RequestBody EnchiridionRepresentation.updateEnchiridion enchiridion){
        try{
            return ResponseEntity.ok().body(EnchiridionRepresentation.enchiridionResponse.fromEnchiridion(service.update(id, enchiridion)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EnchiridionRepresentation.enchiridionResponse> deleteEnchiridion(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
