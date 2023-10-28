package com.FitGo.controller.interfaces;

import com.FitGo.controller.DTO.WorkoutPlanReqDTO;
import com.FitGo.controller.DTO.WorkoutPlanResDTO;
import com.FitGo.model.Exercise;
import com.FitGo.model.WorkoutPlan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IWorkoutPlanController {

    public ResponseEntity<WorkoutPlan> createWorkoutPlan(WorkoutPlanReqDTO workoutPlanReqDTO);
    public ResponseEntity<String> updateWorkoutPlan(WorkoutPlanReqDTO workoutPlanReqDTO);
    public ResponseEntity<String> deleteWorkoutPlan(String name);

    public ResponseEntity<List<WorkoutPlanReqDTO>> getAllWorkoutPlans();


}
