package com.example.PawsTime.pet;

import com.example.PawsTime.breed.Breed;
import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.enums.Gender;
import com.example.PawsTime.petowners.Owner;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends EntityId {
    @Column(name = "name")
    private String name;
    @Column(name = "owner_id")
    private String owner;
    @OneToOne
    @JoinColumn(name = "breed_id")
    private Breed breed;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "size")
    private String size;
    @Column(name = "weight")
    private String weight;
    @Column(name = "age")
    private String age;
}
