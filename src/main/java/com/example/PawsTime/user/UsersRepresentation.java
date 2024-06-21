package com.example.PawsTime.user;

import com.example.PawsTime.clinic.Clinic;
import com.example.PawsTime.enums.Gender;
import lombok.*;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;

public interface UsersRepresentation {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class UserResponse {
        private Long id;
        private Clinic clinics_id;
        private String name;
        private String birthdate;
        private Gender gender;
        private String cellphone;
        private String document;
        private String address;
        private String speciality;
        private Boolean active;
        private String login;
        private String password;
        private String type;

        public static UserResponse from(Users user) {
            return UserResponse.builder()
                    .id(user.getId())
                    .clinics_id(user.getClinics_id())
                    .name(user.getName())
                    .birthdate(user.getBirthdate())
                    .gender(user.getGender())
                    .cellphone(user.getCellphone())
                    .document(user.getDocument())
                    .address(user.getAddress())
                    .speciality(user.getSpeciality())
                    .active(user.getActive())
                    .login(user.getLogin())
                    .password(user.getPassword())
                    .type(user.getType())
                    .build();
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class UserCreate {
        private Clinic clinics_id;
        private String name;
        private String birthdate;
        private Gender gender;
        private String cellphone;
        private String document;
        private String address;
        private String speciality;
        private Boolean active;
        private String login;
        private String password;
        private String type;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class UserUpdate {
        private Clinic clinics_id;
        private String name;
        private String birthdate;
        private Gender gender;
        private String cellphone;
        private String document;
        private String address;
        private String speciality;
        private Boolean active;
        private String login;
        private String password;
        private String type;
    }
}
