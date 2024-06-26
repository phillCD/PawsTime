package com.example.PawsTime.clinic;

import com.example.PawsTime.core.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clinic extends EntityId {
    @Column(name = "name")
    private String name;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "address")
    private String address;
}
