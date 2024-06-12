package com.example.PawsTime.enchiridion;

import com.example.PawsTime.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface EnchiridionRepresentation {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class createEnchiridion{
        @NotNull
        @NotBlank
        private Pet petId;
        @NotNull
        @NotBlank
        private String anamnese;
        @NotNull
        @NotBlank
        private String prescription;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class updateEnchiridion{
        @NotNull
        @NotBlank
        private Pet petId;
        @NotNull
        @NotBlank
        private String anamnese;
        @NotNull
        @NotBlank
        private String prescription;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class enchiridionResponse{
        private Long id;
        private Pet petId;
        private String anamnese;
        private String prescription;

        public static enchiridionResponse fromEnchiridion(Enchiridion enchiridion){
            return enchiridionResponse.builder()
                    .id(enchiridion.getId())
                    .petId(enchiridion.getPetId())
                    .anamnese(enchiridion.getAnamnese())
                    .prescription(enchiridion.getPrescription())
                    .build();
        }
    }

}
