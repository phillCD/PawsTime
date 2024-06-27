package com.example.PawsTime.user;

import com.example.PawsTime.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UsersController {
    private UsersService service;

    @GetMapping
    public ResponseEntity<List<UsersRepresentation.UserResponse>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers().stream().map(UsersRepresentation.UserResponse::from).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<UsersRepresentation.UserResponse> getUserById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(UsersRepresentation.UserResponse.from(service.getUserById(id)));
        } catch (NotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<UsersRepresentation.UserResponse> createUser(@RequestBody UsersRepresentation.UserCreate user){
        return ResponseEntity.ok(UsersRepresentation.UserResponse.from(service.createUser(user)));
    }

    @PostMapping("{id}")
    public ResponseEntity<UsersRepresentation.UserResponse> updateUser(@PathVariable Long id, @RequestBody UsersRepresentation.UserUpdate user){
        try{
            return ResponseEntity.ok(UsersRepresentation.UserResponse.from(service.update(id, user)));
        } catch (NotFoundException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("login")
    public ResponseEntity<UsersRepresentation.UserResponse> login(@RequestBody UsersRepresentation.UserLogin userLogin) {
        try {
            Users user = service.authenticate(userLogin);
            return ResponseEntity.ok(UsersRepresentation.UserResponse.from(user));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UsersRepresentation.UserResponse> deleteUser(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
