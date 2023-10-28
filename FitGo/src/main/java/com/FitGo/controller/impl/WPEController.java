package com.FitGo.controller.impl;


import com.FitGo.controller.DTO.ExerciseResDTO;
import com.FitGo.controller.DTO.WorkoutPlanReqDTO;
import com.FitGo.controller.DTO.WorkoutPlanResDTO;
import com.FitGo.controller.interfaces.IWPEController;
import com.FitGo.model.User;
import com.FitGo.model.WorkoutPlan;
import com.FitGo.model.WorkoutPlanExercise;
import com.FitGo.repository.UserRepository;
import com.FitGo.repository.WorkoutPlanRepository;
import com.FitGo.service.interfaces.IWPEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WPEController implements IWPEController {

    @Autowired
    IWPEService iwpeService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WorkoutPlanRepository workoutPlanRepository;

    @Override
    @GetMapping("/{username}/view-plan")
    public ResponseEntity<WorkoutPlanResDTO> getWorkoutPlanByUsername(@PathVariable String username) {
        System.out.println("Username =>"+username);

        User user = userRepository.findByUsername(username);
        Optional<WorkoutPlan> plan = workoutPlanRepository.findById(user.getWorkoutPlan().getId());


        WorkoutPlanResDTO workoutPlanResDTO = new WorkoutPlanResDTO();
        workoutPlanResDTO.setUsername(user.getUsername());
        workoutPlanResDTO.setPlan(plan.get().getName());
        List<Object[]> list= iwpeService.getWorkoutPlanByUsername(username);
        System.out.println(list);
        for (Object[] row : list) {
            String exerciseName = (String) row[0];
            Integer repetitions = (Integer) row[1];
            Integer sets = (Integer) row[2];


            ExerciseResDTO exerciseDetailsDTO = new ExerciseResDTO(exerciseName, repetitions, sets);
            workoutPlanResDTO.addExerciseDetail(exerciseDetailsDTO);
        }

        return ResponseEntity.ok(workoutPlanResDTO);
    }
}
