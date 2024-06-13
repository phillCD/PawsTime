package com.example.PawsTime.breed;

import com.example.PawsTime.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface BreedRepresentation {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class createBreed{
        @NotNull
        @NotEmpty
        private String name;
        @NotNull
        @NotEmpty
        private Category category;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class updateBreed{
        @NotNull
        @NotEmpty
        private String name;
        @NotNull
        @NotEmpty
        private Category category;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class breedResponse{
        private Long id;
        private String name;
        private Category category;

        public static breedResponse fromBreed(Breed breed){
            return breedResponse.builder()
                    .id(breed.getId())
                    .name(breed.getName())
                    .category(breed.getCategory())
                    .build();
        }
    }
}
