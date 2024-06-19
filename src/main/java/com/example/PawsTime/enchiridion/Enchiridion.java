package com.example.PawsTime.enchiridion;

import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.pet.Pet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enchiridion extends EntityId {
    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet petId;
    @Column(name = "anamnese")
    private String anamnese;
    @Column(name = "prescription")
    private String prescription;
}
