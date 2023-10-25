package com.FitGo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Exercise {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ExerciseCategory category;

    @OneToMany(mappedBy = "exercise")
    @JsonIgnore
    private List<WorkoutPlanExercise> workoutPlanExercises;

    public Exercise(String name, String description, ExerciseCategory category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }
}
