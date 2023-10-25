package com.FitGo.controller.DTO;

import lombok.Data;

import java.util.List;

@Data
public class WorkoutPlanReqDTO {
    private String name;
    private Integer duration;
    private List<ExerciseDetailDTO> exercises;
}
