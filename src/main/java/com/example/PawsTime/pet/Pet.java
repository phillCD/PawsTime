package com.example.PawsTime.pet;

import com.example.PawsTime.core.EntityId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pet extends EntityId {
    private String name;
    private String owner_id;
    private String breed;
    private String gender;
    private String size;
    private String animal;
    private String weight;
    private String age;
}
