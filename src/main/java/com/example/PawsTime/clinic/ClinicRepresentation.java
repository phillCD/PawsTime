package com.example.PawsTime.clinic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface ClinicRepresentation {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class createClinic{
        @NotNull
        @NotEmpty
        private String name;
        @NotNull
        @NotEmpty
        private String cellphone;
        @NotNull
        @NotEmpty
        private String address;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class updateClinic{
        @NotNull
        @NotEmpty
        private String name;
        @NotNull
        @NotEmpty
        private String cellphone;
        @NotNull
        @NotEmpty
        private String address;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class clinicResponse{
        private Long id;
        private String name;
        private String cellphone;
        private String address;

        public static clinicResponse from(Clinic clinic){
            return clinicResponse.builder()
                    .id(clinic.getId())
                    .name(clinic.getName())
                    .cellphone(clinic.getCellphone())
                    .address(clinic.getAddress())
                    .build();
        }
    }
}
