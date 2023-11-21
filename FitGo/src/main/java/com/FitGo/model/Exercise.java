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
    private String muscleGroup;
    private String image;

    @Enumerated(EnumType.STRING)
    private ExerciseCategory category;

    @OneToMany(mappedBy = "exercise")
    @JsonIgnore
    private List<WorkoutPlanExercise> workoutPlanExercises;


    public Exercise(String name, String description, String muscleGroup, String image, ExerciseCategory category) {
        this.name = name;
        this.description = description;
        this.muscleGroup = muscleGroup;
        this.image = image;
        this.category = category;
    }
}
