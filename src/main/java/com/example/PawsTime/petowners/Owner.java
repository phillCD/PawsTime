package com.example.PawsTime.petowners;
import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Owner extends EntityId{
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private String pet_id;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "address")
    private String address;
    @Column(name = "document")
    private String document;
    @Column(name = "birthdate")
    private String birthdate;
    @Column(name = "gender")
    private String gender;


}
