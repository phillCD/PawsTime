package com.example.PawsTime.schedule;

import com.example.PawsTime.clinic.Clinic;
import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.user.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule extends EntityId {
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user_id;
    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic_id;
    @Column(name = "date_start")
    private String date_start;
    @Column(name = "date_finish")
    private String date_finish;
    @Column(name = "hour_start")
    private String hour_start;
    @Column(name = "hour_finish")
    private String hour_finish;
    @Column(name = "horary")
    private String horary;
    @Column(name = "duration")
    private String duration;
}
