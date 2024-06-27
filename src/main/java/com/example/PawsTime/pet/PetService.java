package com.example.PawsTime.pet;

import com.example.PawsTime.clinic.QClinic;
import com.example.PawsTime.exceptions.NotFoundException;
import com.example.PawsTime.petowners.QOwner;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets() {return petRepository.findAll();}

    public Pet getPetById(Long id) {return petRepository.findById(id).orElse(null);}

    public List<Pet> getPetsByClinicsId(Long clinicId) {
        QPet qPet = QPet.pet;
        QOwner qOwner = QOwner.owner;
        QClinic qClinic = QClinic.clinic;

        JPAQuery<Pet> query =  new JPAQuery<Pet>(entityManager);

        return query.from(qPet)
                .join(qPet.owner, qOwner)
                .join(qOwner.clinics, qClinic)
                .where(qClinic.id.eq(clinicId))
                .fetch();
    }

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
