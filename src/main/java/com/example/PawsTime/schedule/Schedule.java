package com.example.PawsTime.schedule;

import com.example.PawsTime.core.EntityId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Schedule extends EntityId {
    private String user_id;
    private String clinic_id;
    private String date_start;
    private String date_finish;
    private String hour_start;
    private String hour_finish;
    private String horary;
    private String duration;
}
