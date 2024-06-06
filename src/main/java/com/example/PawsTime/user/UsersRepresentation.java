package com.example.PawsTime.user;

import com.example.PawsTime.clinic.Clinic;
import com.example.PawsTime.enums.Gender;
import lombok.*;

import javax.validation.constraints.*;
import java.util.Set;

public interface UsersRepresentation {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class UserCreate{
        @NotNull
        @Size(min = 3, max = 50)
        private String login;

        @NotNull
        @NotEmpty
        private Clinic clinicId;

        @NotNull(message = "Name is required")
        @NotEmpty(message = "Name is required")
        private String name;

        @NotNull
        @Size(min = 6, max = 40)
        private String password;

        private Set<String> type;

        @NotNull(message = "Document is required")
        @NotEmpty(message = "Document is required")
        private String document;

        @NotNull(message = "Birthdate is required")
        @NotEmpty(message = "Birthdate is required")
        private String birthdate;

        @NotNull
        @NotBlank
        private String address;

        @NotBlank
        @NotNull
        private Gender gender;

        @NotNull
        @NotBlank
        private String cellphone;

        @NotNull
        @NotBlank
        private String speciality;

        @NotNull
        @NotBlank
        private Boolean active;

    }

    class UserUpdate {
        @NotNull
        @Size(min = 3, max = 50)
        private String login;

        @NotNull
        @NotEmpty
        private Clinic clinicId;

        @NotNull(message = "Name is required")
        @NotEmpty(message = "Name is required")
        private String name;

        @NotNull
        @Size(min = 6, max = 40)
        private String password;

        private Set<String> type;

        @NotNull(message = "Document is required")
        @NotEmpty(message = "Document is required")
        private String document;

        @NotNull(message = "Birthdate is required")
        @NotEmpty(message = "Birthdate is required")
        private String birthdate;

        @NotNull
        @NotBlank
        private String address;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class UserResponse {
        private Long id;
        private String login;
        private Clinic clinic_id;
        private String name;
        private String document;
        private String birthdate;
        private String address;


        public static UserResponse from(Users user) {
            return UserResponse.builder()
                    .id(user.getId())
                    .login(user.getLogin())
                    .clinic_id((Clinic) user.getClinics())
                    .name(user.getName())
                    .document(user.getDocument())
                    .birthdate(user.getBirthdate())
                    .address(user.getAddress())
                    .build();
        }
    }
}
