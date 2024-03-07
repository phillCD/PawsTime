package com.example.PawsTime.appointments;

import com.example.PawsTime.core.EntityId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Appointments extends EntityId {
    private String schedule_id;
    private String user_id;
    private String pet_id;
    private String procedure;
    private String date;
    private String hour;
}
