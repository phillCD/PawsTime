package com.example.PawsTime.petowners;

import com.example.PawsTime.clinic.QClinic;
import com.example.PawsTime.exceptions.NotFoundException;
import com.example.PawsTime.pet.Pet;
import com.example.PawsTime.pet.QPet;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @PersistenceContext
    private EntityManager entityManager;
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

    public List<Owner> getOwnersByClinicsId(Long clinicId) {
        QOwner qOwner = QOwner.owner;
        QClinic qClinic = QClinic.clinic;

        JPAQuery<Owner> query =  new JPAQuery<Owner>(entityManager);

        return query.from(qOwner)
                .join(qOwner.clinics, qClinic)
                .where(qClinic.id.eq(clinicId))
                .fetch();
    }

    public Owner createOwner(OwnerRepresentation.OwnerCreate create) {
        return ownerRepository.save(new Owner(
                create.getName(),
                create.getPet_id(),
                create.getCellphone(),
                create.getAddress(),
                create.getDocument(),
                create.getBirthdate(),
                create.getGender(),
                create.getClinics()
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
