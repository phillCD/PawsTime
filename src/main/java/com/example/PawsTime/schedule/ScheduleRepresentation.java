package com.example.PawsTime.schedule;

import com.example.PawsTime.clinic.Clinic;
import com.example.PawsTime.petowners.Owner;
import com.example.PawsTime.petowners.OwnerRepresentation;
import com.example.PawsTime.user.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public interface ScheduleRepresentation {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class createSchedule{
        private Users user_id;
        private Clinic clinic_id;
        private String date_start;
        private String date_finish;
        private String hour_start;
        private String hour_finish;
        private String horary;
        private String duration;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class updateSchedule{
        private Users user_id;
        private Clinic clinic_id;
        private String date_start;
        private String date_finish;
        private String hour_start;
        private String hour_finish;
        private String horary;
        private String duration;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class ScheduleResponse{
        private Long id;
        private Users user_id;
        private Clinic clinicId;
        private String date_start;
        private String date_finish;
        private String hour_start;
        private String hour_finish;
        private String horary;
        private String duration;

        public static ScheduleResponse from(Schedule schedule){
            return ScheduleResponse.builder()
                    .id(schedule.getId())
                    .user_id(schedule.getUser_id())
                    .clinicId(schedule.getClinic_id())
                    .date_start(schedule.getDate_start())
                    .date_finish(schedule.getDate_finish())
                    .hour_start(schedule.getHour_start())
                    .hour_finish(schedule.getHour_finish())
                    .horary(schedule.getHorary())
                    .duration(schedule.getDuration())
                    .build();
        }


        public static List<ScheduleResponse> from(List<Schedule> schedules){
            return schedules.stream()
                    .map(ScheduleResponse::from)
                    .collect(Collectors.toList());
        }
    }
}