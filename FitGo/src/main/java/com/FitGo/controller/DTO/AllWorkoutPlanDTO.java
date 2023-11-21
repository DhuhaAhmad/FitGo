package com.FitGo.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AllWorkoutPlanDTO {

    private String name;
    private Integer duration;
    private List<ExerciseResDTO> exercises=  new ArrayList<>();;

    public void addExerciseDetail(ExerciseResDTO exerciseResDTO) {
        this.exercises.add(exerciseResDTO);
    }
}
