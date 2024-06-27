package com.example.PawsTime.breed;

import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.enums.Animals;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class  Breed extends EntityId {
    @Column(name = "name")
    private String name;
    @Column(name = "animal")
    private Animals animal;

    public Breed(Long id) {
        super(id);
    }
}
