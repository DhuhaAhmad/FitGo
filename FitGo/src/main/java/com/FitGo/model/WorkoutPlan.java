package com.FitGo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
//@Data
@Setter
@Getter
@Entity

public class WorkoutPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer duration;



    @OneToMany(mappedBy = "workoutPlan")
    private List<WorkoutPlanExercise> workoutPlanExercises;

    @OneToMany(mappedBy = "workoutPlan")
    @JsonIgnore
    private List<User> users;


    public WorkoutPlan(String name, Integer duration) {
        this.name = name;
        this.duration = duration;
    }
}
