package com.example.PawsTime.auth;

import com.example.PawsTime.clinic.Clinic;
import com.example.PawsTime.user.Users;
import com.example.PawsTime.user.UsersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final UsersRepository usersRepository;

    public LoginController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<Users> postController(@RequestBody Login login) {
        Users selectedUser = usersRepository.findByUsername(login.username);

        if (selectedUser != null) {
            if (selectedUser.getPassword().equals(login.password)) {
                return ResponseEntity.ok(selectedUser);
            }
        };

        return null;
    }
}

