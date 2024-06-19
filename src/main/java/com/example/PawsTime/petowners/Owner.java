package com.example.PawsTime.petowners;
import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.enums.Gender;
import com.example.PawsTime.pet.Pet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner extends EntityId{
    @Column(name = "name")
    private String name;
    @OneToMany
    @JoinColumn(name = "pet_id")
    private List<Pet> pet;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "address")
    private String address;
    @Column(name = "document")
    private String document;
    @Column(name = "birthdate")
    private String birthdate;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

}
