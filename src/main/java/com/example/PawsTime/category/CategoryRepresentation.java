package com.example.PawsTime.category;

import lombok.*;

import javax.validation.constraints.NotBlank;
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
    @Setter
    @Getter
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
    @Setter
    @Getter
    class categoryResponse{
        private Long id;
        private String name;

        public static categoryResponse from(Category category){
            return categoryResponse.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .build();
        }
    }
}
