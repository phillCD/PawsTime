package com.example.PawsTime.petowners;

import com.example.PawsTime.exceptions.NotFoundException;
import com.example.PawsTime.pet.Pet;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public Owner createOwner(OwnerRepresentation.OwnerCreate create) {
        return ownerRepository.save(new Owner(
                create.getName(),
                create.getPet_id(),
                create.getCellphone(),
                create.getAddress(),
                create.getDocument(),
                create.getBirthdate(),
                create.getGender()
        ));
    }

    public Owner update(Long id, OwnerRepresentation.OwnerUpdate entity) {
        var dbEntity = ownerRepository.findById(id).orElseThrow(() -> new NotFoundException("Owner"));
        modelMapper.map(entity, dbEntity);

        return ownerRepository.save(dbEntity);
    }

    public Owner delete(Long id) {
        var dbEntity = ownerRepository.findById(id).orElseThrow(() -> new NotFoundException("Owner"));
        ownerRepository.delete(dbEntity);
        return dbEntity;
    }
}
