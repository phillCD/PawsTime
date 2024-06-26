package com.example.PawsTime.user;

import com.example.PawsTime.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public Users createUser(UsersRepresentation.UserCreate create) {
        return usersRepository.save(new Users(
                create.getClinics_id(),
                create.getName(),
                create.getBirthdate(),
                create.getGender(),
                create.getCellphone(),
                create.getDocument(),
                create.getAddress(),
                create.getSpeciality(),
                create.getActive(),
                create.getLogin(),
                create.getPassword(),
                create.getType()
        ));
    }

    public Users update(Long id, UsersRepresentation.UserUpdate entity) {
        var dbEntity = usersRepository.findById(id).orElseThrow(() -> new NotFoundException("Apostador"));
        modelMapper.map(entity, dbEntity);

        return usersRepository.save(dbEntity);
    }

    public Users delete(Long id) {
        var dbEntity = usersRepository.findById(id).orElseThrow(() -> new NotFoundException("Apostador"));
        usersRepository.delete(dbEntity);
        return dbEntity;
    }
}
