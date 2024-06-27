package com.example.PawsTime.user;

import com.example.PawsTime.clinic.Clinic;
import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public class Users extends EntityId {
    @ManyToOne
    @JoinColumn(name = "clinics_id")
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
