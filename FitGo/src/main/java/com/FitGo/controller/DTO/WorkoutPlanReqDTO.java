package com.FitGo.controller.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WorkoutPlanReqDTO {
    private String name;
    private Integer duration;
    private List<ExerciseDetailDTO> exercises=  new ArrayList<>();;

    public void addExerciseDetail(ExerciseDetailDTO exerciseDetails) {
        this.exercises.add(exerciseDetails);
    }

}
