package com.FitGo.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExerciseDetailDTO {
    private String exerciseName;
    private Integer reps;
    private Integer sets;
}
