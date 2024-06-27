package com.example.PawsTime.petowners;

import com.example.PawsTime.clinic.Clinic;
import com.example.PawsTime.enums.Gender;
import com.example.PawsTime.pet.Pet;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        @NotEmpty
        private String email;
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
        @Enumerated(EnumType.STRING)
        private Gender gender;
        @NotNull
        @NotBlank
        private Set<Clinic> clinics;
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
        @NotEmpty
        private String email;
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
        @Enumerated(EnumType.STRING)
        private Gender gender;
        @NotNull
        @NotBlank
        private Set<Clinic> clinics;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class OwnerResponse {
        private Long id;
        private String name;
        private String email;
        private String cellphone;
        private String address;
        private String document;
        private String birthdate;
        private Gender gender;
        private Set<Clinic> clinics;

        public static OwnerResponse fromOwner(Owner owner) {
            return OwnerResponse.builder()
                    .id(owner.getId())
                    .name(owner.getName())
                    .email(owner.getEmail())
                    .cellphone(owner.getCellphone())
                    .address(owner.getAddress())
                    .document(owner.getDocument())
                    .birthdate(owner.getBirthdate())
                    .gender(owner.getGender())
                    .clinics(owner.getClinics())
                    .build();
        }
    }
}
