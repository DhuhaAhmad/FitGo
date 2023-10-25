package com.FitGo.model;

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

//    @OneToMany(mappedBy = "workoutPlans")
//    private List<Exercise> exercises;

    @OneToMany(mappedBy = "workoutPlan")
    private List<WorkoutPlanExercise> workoutPlanExercises;

    @OneToMany(mappedBy = "workoutPlan")
    private List<User> users;

//    @ManyToMany
//    @JoinTable(name = "workout_plan_exercise",
//            joinColumns = @JoinColumn(name = "workout_plan_id"),
//            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
//    private List<Exercise> exercises;

    public WorkoutPlan(String name, Integer duration) {
        this.name = name;
        this.duration = duration;
    }
}
