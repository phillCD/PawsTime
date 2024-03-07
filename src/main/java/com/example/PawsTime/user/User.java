package com.example.PawsTime.user;

import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends EntityId {
    @ManyToMany
    @JoinColumn(name = "clinic_id", nullable = false)
    private Long clinicId;
    @NonNull
    @Column(name = "name")
    private String name;
    @NonNull
    @Column(name = "birth_date")
    private String birthDate;
    @NonNull
    @Column(name = "gender")
    private Gender gender;
    @NonNull
    @Column(name = "cellphone")
    private String cellphone;
    @NonNull
    @Column(name = "document")
    private String document;
    @NonNull
    @Column(name = "address")
    private String address;
    @Column(name = "speciality")
    private String speciality;
    @Column(name = "active")
    private Boolean active;
    @NonNull
    @Column(name = "login")
    private String login;
    @NonNull
    @Column(name = "password")
    private String password;
    @NonNull
    @Column(name = "type")
    private Integer type;
}
