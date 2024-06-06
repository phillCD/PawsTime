package com.example.PawsTime.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {
    private UsersService service;

    @GetMapping
    public ResponseEntity<List<UsersRepresentation.UserResponse>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers().stream().map(UsersRepresentation.UserResponse::from).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<UsersRepresentation.UserResponse> getUserById(Long id){
        try{
            return ResponseEntity.ok(UsersRepresentation.UserResponse.from(service.getUserById(id)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<UsersRepresentation.UserResponse> updateUser(@PathVariable Long id, @RequestBody UsersRepresentation.UserUpdate user){
        try{
            return ResponseEntity.ok().body(UsersRepresentation.UserResponse.from(service.update(id, user)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UsersRepresentation.UserResponse> deleteUser(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
