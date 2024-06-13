package com.example.PawsTime.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface CategoryRepresentation {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class createCategory{
        @NotBlank
        @Size(min = 3, max = 20)
        private String name;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class updateCategory{
        @NotBlank
        @Size(min = 3, max = 20)
        private String name;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class categoryResponse{
        private Long id;
        private String name;

        public static categoryResponse fromCategory(Category category){
            return categoryResponse.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .build();
        }
    }
}
