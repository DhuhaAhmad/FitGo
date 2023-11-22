package com.FitGo.controller.impl;


import com.FitGo.controller.DTO.AllWorkoutPlanDTO;
import com.FitGo.controller.DTO.WorkoutPlanReqDTO;
import com.FitGo.controller.interfaces.IWorkoutPlanController;
import com.FitGo.model.WorkoutPlan;
import com.FitGo.repository.WorkoutPlanRepository;
import com.FitGo.service.impl.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutPlanController implements IWorkoutPlanController {

    @Autowired
    WorkoutPlanRepository workoutPlanRepository;

    @Autowired
    WorkoutPlanService workoutPlanService;


    @Override
    @GetMapping("/view-all-plans")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<AllWorkoutPlanDTO>> getAllWorkoutPlans() {
        List<AllWorkoutPlanDTO> workoutPlans = workoutPlanService.showAllWorkoutPlans();
        return ResponseEntity.ok(workoutPlans);
    }


    @Override
    @PostMapping("/create-plan")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<WorkoutPlan> createWorkoutPlan(@RequestBody WorkoutPlanReqDTO workoutPlanReqDTO) {

        WorkoutPlan createdPlan = workoutPlanService.createWorkoutPlan(workoutPlanReqDTO);
        return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);

    }


    @Override
    @PutMapping("/update-workout-plan")
    public ResponseEntity<String> updateWorkoutPlan(@RequestBody WorkoutPlanReqDTO workoutPlanReqDTO) {

        String updatedPlan = workoutPlanService.updateWorkoutPlan(workoutPlanReqDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @Override
    @DeleteMapping("/delete-workout-plan")
    public ResponseEntity<String> deleteWorkoutPlan(@RequestParam String name) {
        String deletedPlan = workoutPlanService.deleteWorkoutPlanByName(name);

        return new ResponseEntity<>( HttpStatus.OK);
    }


}


