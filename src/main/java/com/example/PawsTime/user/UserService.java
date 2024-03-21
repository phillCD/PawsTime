package com.example.PawsTime.user;

import com.example.PawsTime.exceptions.NotFoundException;
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

    public User createUser(UserRepresentation.UserCreate create) {
        return userRepository.save(new User(
                create.getLogin(),
                create.getClinicId(),
                create.getName(),
                create.getPassword(),
                create.getType(),
                create.getDocument(),
                create.getBirthdate(),
                create.getAddress(),
                create.getGender(),
                create.getCellphone(),
                create.getSpeciality(),
                create.getActive()
        ));
    }

    public User update(Long id, UserRepresentation.UserUpdate entity) {
        var dbEntity = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Apostador"));
        modelMapper.map(entity, dbEntity);

        return userRepository.save(dbEntity);
    }

    public User delete(Long id) {
        var dbEntity = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Apostador"));
        userRepository.delete(dbEntity);
        return dbEntity;
    }
}
