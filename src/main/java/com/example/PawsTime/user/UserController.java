package com.example.PawsTime.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserRepresentation.UserResponse>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers().stream().map(UserRepresentation.UserResponse::from).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserRepresentation.UserResponse> getUserById(Long id){
        try{
            return ResponseEntity.ok(UserRepresentation.UserResponse.from(service.getUserById(id)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<UserRepresentation.UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRepresentation.UserUpdate user){
        try{
            return ResponseEntity.ok().body(UserRepresentation.UserResponse.from(service.update(id, user)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserRepresentation.UserResponse> deleteUser(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
