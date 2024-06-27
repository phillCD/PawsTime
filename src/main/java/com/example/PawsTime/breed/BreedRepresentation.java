package com.example.PawsTime.breed;

import com.example.PawsTime.enums.Animals;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface BreedRepresentation {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Data
    class createBreed{
        @NotNull
        @NotEmpty
        private String name;
        @NotNull
        @NotEmpty
        private Animals animal;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Setter
    @Getter
    class updateBreed{
        @NotNull
        @NotEmpty
        private String name;
        @NotNull
        @NotEmpty
        private Animals animal;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Getter
    @Setter
    class breedResponse{
        private Long id;
        private String name;
        private Animals animal;

        public static breedResponse fromBreed(Breed breed){
            return breedResponse.builder()
                    .id(breed.getId())
                    .name(breed.getName())
                    .animal(breed.getAnimal())
                    .build();
        }
    }
}
