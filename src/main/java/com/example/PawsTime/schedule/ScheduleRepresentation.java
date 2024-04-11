package com.example.PawsTime.schedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface ScheduleRepresentation {
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class createSchedule{
        @NotNull
        @NotEmpty
        private String user_id;
        @NotNull
        @NotEmpty
        private String clinic_id;
        @NotNull
        @NotEmpty
        private String date_start;
        @NotNull
        @NotEmpty
        private String date_finish;
        @NotNull
        @NotEmpty
        private String hour_start;
        @NotNull
        @NotEmpty
        private String hour_finish;
        @NotNull
        @NotEmpty
        private String horary;
        @NotNull
        @NotEmpty
        private String duration;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class updateSchedule{
        @NotNull
        @NotEmpty
        private String user_id;
        @NotNull
        @NotEmpty
        private String clinic_id;
        @NotNull
        @NotEmpty
        private String date_start;
        @NotNull
        @NotEmpty
        private String date_finish;
        @NotNull
        @NotEmpty
        private String hour_start;
        @NotNull
        @NotEmpty
        private String hour_finish;
        @NotNull
        @NotEmpty
        private String horary;
        @NotNull
        @NotEmpty
        private String duration;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class ScheduleResponse{
        private Long id;
        private String user_id;
        private String clinic_id;
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
                    .clinic_id(schedule.getClinic_id())
                    .date_start(schedule.getDate_start())
                    .date_finish(schedule.getDate_finish())
                    .hour_start(schedule.getHour_start())
                    .hour_finish(schedule.getHour_finish())
                    .horary(schedule.getHorary())
                    .duration(schedule.getDuration())
                    .build();
        }
    }
}
