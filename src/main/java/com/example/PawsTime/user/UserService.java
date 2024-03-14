package com.example.PawsTime.user;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /*public User createUser(UserRepresentation.UserCreate create) {
        return userRepository.save(new User(
        ));
    }*/
}
