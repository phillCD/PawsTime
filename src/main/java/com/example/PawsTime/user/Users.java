package com.example.PawsTime.user;

import com.example.PawsTime.clinic.Clinic;
import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users extends EntityId {
    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinics_id;
    @Column(name = "name")
    private String name;
    @Column(name = "birth_date")
    private String birthdate;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "document")
    private String document;
    @Column(name = "address")
    private String address;
    @Column(name = "speciality")
    private String speciality;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "type")
    private String type;
}
