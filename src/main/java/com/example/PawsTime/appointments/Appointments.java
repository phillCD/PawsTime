package com.example.PawsTime.appointments;

import com.example.PawsTime.core.EntityId;
import com.example.PawsTime.pet.Pet;
import com.example.PawsTime.schedule.Schedule;
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
public class Appointments extends EntityId {
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user_id;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet_id;
    @Column(name = "procedure")
    private String procedure;
    @Column(name = "date")
    private String date;
    @Column(name = "hour")
    private String hour;
    @Column(name = "status")
    private String status;
}
