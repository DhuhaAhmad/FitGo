package com.FitGo.controller.interfaces;

import com.FitGo.controller.DTO.WorkoutPlanResDTO;
import com.FitGo.model.WorkoutPlanExercise;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IWPEController {

    public ResponseEntity<WorkoutPlanResDTO> getWorkoutPlanByUsername(String username);
}
