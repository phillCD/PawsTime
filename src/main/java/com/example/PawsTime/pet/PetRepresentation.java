package com.example.PawsTime.pet;

import com.example.PawsTime.breed.Breed;
import com.example.PawsTime.enums.Gender;
import com.example.PawsTime.petowners.Owner;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface PetRepresentation {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class createPet{
        @NotNull
        @NotEmpty
        private String name;
        private Owner owner;
        @NotNull
        @NotEmpty
        private Breed breed;
        @NotNull
        @NotEmpty
        @Enumerated(EnumType.STRING)
        private Gender gender;
        @NotNull
        @NotEmpty
        private String size;
        @NotNull
        @NotEmpty
        private String weight;
        @NotNull
        @NotEmpty
        private String age;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class updatePet{
        @NotNull
        @NotEmpty
        private String name;
        private Owner owner;
        @NotNull
        @NotEmpty
        private Breed breed;
        @NotNull
        @NotEmpty
        @Enumerated(EnumType.STRING)
        private Gender gender;
        @NotNull
        @NotEmpty
        private String size;
        @NotNull
        @NotEmpty
        private String weight;
        @NotNull
        @NotEmpty
        private String age;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class PetResponse{
        private Long id;
        private String name;
        private Owner owner;
        private Breed breed;
        private Gender gender;
        private String size;
        private String weight;
        private String age;

        public static PetResponse from(Pet pet){
            return PetResponse.builder()
                    .id(pet.getId())
                    .name(pet.getName())
                    .owner(pet.getOwner())
                    .breed(pet.getBreed())
                    .gender(pet.getGender())
                    .size(pet.getSize())
                    .weight(pet.getWeight())
                    .age(pet.getAge())
                    .build();
        }
    }
}
