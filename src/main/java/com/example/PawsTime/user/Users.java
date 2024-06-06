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
    @ManyToMany

    @JoinTable(
            name = "user_clinic",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "clinic_id"))
    private List<Clinic> clinics;
    @NonNull
    @Column(name = "name")
    private String name;
    @NonNull
    @Column(name = "birth_date")
    private String birthdate;
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

    public Users(String login, Clinic clinicId, String name, String password, Set<String> type, String document, String birthdate, String address, Gender gender, String cellphone, String speciality, Boolean active) {
        super();
    }
}
