package com.FitGo.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkoutPlanResDTO {
    private String username;
    private String plan;
    private List<ExerciseResDTO> exerciseDTOS =  new ArrayList<>();

    public void addExerciseDetail(ExerciseResDTO exerciseDetails) {
        this.exerciseDTOS.add(exerciseDetails);
    }

}



