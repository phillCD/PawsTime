package com.example.PawsTime.User;

import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.enums.Gender;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends EntityId {
    private Long id;
    private Long clinicId;
    private String name;
    private String birthDate;
    private Gender gender;
    private String cellphone;
    private String document;
    private String address;
    private String speciality;
    private Boolean active;
    private String login;
    private String password;
    private Integer type;
}
