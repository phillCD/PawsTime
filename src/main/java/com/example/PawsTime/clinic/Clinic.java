package com.example.PawsTime.clinic;

import com.example.PawsTime.core.EntityId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Clinic extends EntityId {
    private String name;
    private String cellphone;
    private String address;
}
