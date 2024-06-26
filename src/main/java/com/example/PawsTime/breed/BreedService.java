package com.example.PawsTime.breed;

import com.example.PawsTime.enums.Animals;
import com.example.PawsTime.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BreedRepository breedRepository;

    public List<Breed> getAllBreeds() {
        return breedRepository.findAll();
    }

    public Breed getBreedById(Long id) {
        return breedRepository.findById(id).orElse(null);
    }

    public Breed createBreed(BreedRepresentation.createBreed create) {
        return breedRepository.save(new Breed(
                create.getName(),
                create.getAnimal()
        ));
    }

    public Breed update(Long id, BreedRepresentation.updateBreed entity) {
        var dbEntity = breedRepository.findById(id).orElseThrow(() -> new NotFoundException("Breed"));
        modelMapper.map(entity, dbEntity);

        return breedRepository.save(dbEntity);
    }

    public Breed delete(Long id) {
        var dbEntity = breedRepository.findById(id).orElseThrow(() -> new NotFoundException("Breed"));
        breedRepository.delete(dbEntity);
        return dbEntity;
    }

    public List<Breed> getBreedsByAnimal(Animals animal) {
        return breedRepository.findByAnimal(animal);
    }
}
