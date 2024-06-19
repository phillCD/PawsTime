package com.example.PawsTime.pet;

import com.example.PawsTime.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets() {return petRepository.findAll();}

    public Pet getPetById(Long id) {return petRepository.findById(id).orElse(null);}

    public Pet createPet(PetRepresentation.createPet create){
        return petRepository.save(new Pet(
                create.getName(),
                create.getOwner(),
                create.getBreed(),
                create.getGender(),
                create.getSize(),
                create.getWeight(),
                create.getAge()
        ));
    }

    public Pet update(Long id, PetRepresentation.updatePet entity){
        var dbEntity = petRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet"));
        modelMapper.map(entity, dbEntity);

        return petRepository.save(dbEntity);
    }

    public Pet delete(Long id) {
        var dbEntity = petRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet"));
        petRepository.delete(dbEntity);
        return dbEntity;
    }

}
