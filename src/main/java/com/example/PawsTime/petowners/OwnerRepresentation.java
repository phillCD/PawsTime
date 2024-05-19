package com.example.PawsTime.petowners;

import com.example.PawsTime.enums.Gender;
import com.example.PawsTime.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface OwnerRepresentation {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class OwnerCreate{
        @NotNull
        @NotBlank
        private String name;
        @NotNull
        @NotBlank
        private Pet pet_id;
        @NotNull
        @NotBlank
        private String cellphone;
        @NotNull
        @NotBlank
        private String address;
        @NotNull
        @NotBlank
        private String document;
        @NotNull
        @NotBlank
        private String birthdate;
        @NotNull
        @NotBlank
        private String gender;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class OwnerUpdate {
        @NotNull
        @NotBlank
        private String name;
        @NotNull
        @NotBlank
        private String pet_id;
        @NotNull
        @NotBlank
        private String cellphone;
        @NotNull
        @NotBlank
        private String address;
        @NotNull
        @NotBlank
        private String document;
        @NotNull
        @NotBlank
        private String birthdate;
        @NotNull
        @NotBlank
        private Gender gender;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class OwnerResponse {
        private Long id;
        private String name;
        private String pet_id;
        private String cellphone;
        private String address;
        private String document;
        private String birthdate;
        private Gender gender;

        public static OwnerResponse fromOwner(Owner owner) {
            return OwnerResponse.builder()
                    .id(owner.getId())
                    .name(owner.getName())
                    .pet_id(String.valueOf(owner.getPet_id()))
                    .cellphone(owner.getCellphone())
                    .address(owner.getAddress())
                    .document(owner.getDocument())
                    .birthdate(owner.getBirthdate())
                    .gender(Gender.valueOf(owner.getGender()))
                    .build();
        }
    }
}
