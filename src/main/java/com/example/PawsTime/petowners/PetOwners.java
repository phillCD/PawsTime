package com.example.PawsTime.petowners;
import com.example.PawsTime.core.EntityId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PetOwners extends EntityId{
    private String name;
    private String pet_id;
    private String cellphone;
    private String address;
    private String document;
    private String birthdate;
    private String gender;
}
