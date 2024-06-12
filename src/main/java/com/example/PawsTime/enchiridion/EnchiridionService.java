package com.example.PawsTime.enchiridion;

import com.example.PawsTime.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;

import java.util.List;

public class EnchiridionService {

    private ModelMapper modelMapper;
    private EnchiridionRepository enchiridionRepository;

    public List<Enchiridion> getAllEnchiridions() {return enchiridionRepository.findAll();}

    public Enchiridion getEnchiridionById(Long id) {return enchiridionRepository.findById(id).orElse(null);}

    public Enchiridion createEnchiridion(EnchiridionRepresentation.updateEnchiridion create){
        return enchiridionRepository.save(new Enchiridion(
                create.getPetId(),
                create.getAnamnese(),
                create.getPrescription()
        ));
    }

    public Enchiridion update(Long id, EnchiridionRepresentation.updateEnchiridion entity){
        var dbEntity = enchiridionRepository.findById(id).orElseThrow(() -> new NotFoundException("Enchiridion"));
        modelMapper.map(entity, dbEntity);

        return enchiridionRepository.save(dbEntity);
    }

    public Enchiridion delete(Long id) {
        var dbEntity = enchiridionRepository.findById(id).orElseThrow(() -> new NotFoundException("Enchiridion"));
        enchiridionRepository.delete(dbEntity);
        return dbEntity;
    }
}
