package com.example.PawsTime.enchiridion;

import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.pet.Pet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Enchiridion extends EntityId {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet petId;
    @NonNull
    @Column(name = "anamnese", nullable = false)
    private String anamnese;
    @Column(name = "prescription")
    private String prescription;
}
