package com.example.PawsTime.clinic;

import com.example.PawsTime.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClinicRepository clinicRepository;

    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public Clinic getClinicById(Long id) {
        return clinicRepository.findById(id).orElse(null);
    }

    public Clinic createClinic(ClinicRepresentation.createClinic create) {
        return clinicRepository.save(new Clinic(
                create.getName(),
                create.getCellphone(),
                create.getAddress()
        ));
    }

    public Clinic update(Long id, ClinicRepresentation.updateClinic entity) {
        var dbEntity = clinicRepository.findById(id).orElseThrow(() -> new NotFoundException("Clinic"));
        modelMapper.map(entity, dbEntity);

        return clinicRepository.save(dbEntity);
    }

    public Clinic delete(Long id) {
        var dbEntity = clinicRepository.findById(id).orElseThrow(() -> new NotFoundException("Clinic"));
        clinicRepository.delete(dbEntity);
        return dbEntity;
    }
}
