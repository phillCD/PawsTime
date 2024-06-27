package com.example.PawsTime.appointments;

import com.example.PawsTime.pet.Pet;
import com.example.PawsTime.schedule.Schedule;
import com.example.PawsTime.user.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public interface AppointmentsRepresentation {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class createAppointments{
        private Schedule schedule_id;
        private Pet pet_id;
        private Users user_id;
        private String procedure;
        private String date;
        private String hour;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class updateAppointments{
        private Schedule schedule_id;
        private Pet pet_id;
        private Users user_id;
        private String procedure;
        private String date;
        private String hour;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class appointmentsResponse{
        private Long id;
        private Schedule schedule_id;
        private Pet pet_id;
        private Users user_id;
        private String procedure;
        private String date;
        private String hour;

        public static appointmentsResponse fromAppointments(Appointments appointments){
            return appointmentsResponse.builder()
                    .id(appointments.getId())
                    .schedule_id(appointments.getSchedule_id())
                    .pet_id(appointments.getPet_id())
                    .user_id(appointments.getUser())
                    .procedure(appointments.getProcedure())
                    .date(appointments.getDate())
                    .hour(appointments.getHour())
                    .build();
        }

        public static List<appointmentsResponse> fromAppointments(List<Appointments> appointments){
            return appointments.stream()
                    .map(appointmentsResponse::fromAppointments)
                    .collect(Collectors.toList());
        }
    }
}
