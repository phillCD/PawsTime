package com.example.PawsTime.user;

import com.example.PawsTime.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersService {
    private ModelMapper modelMapper;
    private UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public Users createUser(UsersRepresentation.UserCreate create) {
        return usersRepository.save(new Users(
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
