package com.example.PawsTime.enchiridion;

import com.example.PawsTime.core.EntityId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Enchiridion extends EntityId {
    @OneToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Long petId;
    @NonNull
    @Column(name = "anamnese", nullable = false)
    private String anamnese;
    @Column(name = "prescription")
    private String prescription;
}
