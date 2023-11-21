package com.FitGo.controller.impl;


import com.FitGo.controller.DTO.ExerciseDetailDTO;
import com.FitGo.controller.DTO.ExerciseResDTO;
import com.FitGo.controller.DTO.UserWorkoutPlanResDTO;
import com.FitGo.controller.interfaces.IWPEController;
import com.FitGo.model.User;
import com.FitGo.model.WorkoutPlan;
import com.FitGo.repository.UserRepository;
import com.FitGo.repository.WorkoutPlanRepository;
import com.FitGo.service.interfaces.IWPEService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<UserWorkoutPlanResDTO> getWorkoutPlanByUsername(@PathVariable String username) {
        System.out.println("Username =>"+username);

        User user = userRepository.findByUsername(username);
        Optional<WorkoutPlan> plan = workoutPlanRepository.findById(user.getWorkoutPlan().getId());


        UserWorkoutPlanResDTO userWorkoutPlanResDTO = new UserWorkoutPlanResDTO();
        userWorkoutPlanResDTO.setUsername(user.getUsername());
        userWorkoutPlanResDTO.setPlan(plan.get().getName());
        List<Object[]> list= iwpeService.getWorkoutPlanByUsername(username);
//        System.out.println(list);
        for (Object[] row : list) {
            String exerciseName = (String) row[0];
            String muscleGroup = (String) row[1];
            String image = (String) row[2];
            Integer repetitions = (Integer) row[3];
            Integer sets = (Integer) row[4];



            ExerciseResDTO exerciseResDTO = new ExerciseResDTO(exerciseName, repetitions, sets,muscleGroup,image);
            userWorkoutPlanResDTO.addExerciseDetail(exerciseResDTO);
        }

        return ResponseEntity.ok(userWorkoutPlanResDTO);
    }
}
