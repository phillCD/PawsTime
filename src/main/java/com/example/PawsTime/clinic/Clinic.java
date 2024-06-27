package com.example.PawsTime.clinic;

import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.petowners.Owner;
import com.example.PawsTime.user.Users;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public class Clinic extends EntityId {
    @OneToMany(mappedBy="clinics_id")
    private Set<Users> users;
    @Column(name = "name")
    private String name;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "address")
    private String address;

    @ManyToMany
    @JoinTable(
        name = "clinic_owner",
        joinColumns = @JoinColumn(name = "clinic_id"),
        inverseJoinColumns = @JoinColumn(name = "owner_id"))
    Set<Owner> owners;

    public Clinic(String name, String cellphone, String address) {
    }
}
