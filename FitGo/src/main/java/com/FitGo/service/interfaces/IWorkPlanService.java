package com.FitGo.service.interfaces;

import com.FitGo.controller.DTO.AllWorkoutPlanDTO;
import com.FitGo.controller.DTO.WorkoutPlanReqDTO;
import com.FitGo.model.WorkoutPlan;

import java.util.List;

public interface IWorkPlanService {

    public WorkoutPlan createWorkoutPlan(WorkoutPlanReqDTO workoutPlanReqDTO);
    public String  updateWorkoutPlan(WorkoutPlanReqDTO workoutPlanReqDTO);

    public String deleteWorkoutPlanByName(String name);

    public List<AllWorkoutPlanDTO> showAllWorkoutPlans();
}
