package com.FitGo.service.impl;

import com.FitGo.model.User;
import com.FitGo.model.WorkoutPlan;
import com.FitGo.repository.UserRepository;
import com.FitGo.repository.WorkoutPlanRepository;
import com.FitGo.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    WorkoutPlanRepository workoutPlanRepository;


    @Override
    public String assignUserToWorkoutPlan(String username, String planName) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        Optional<WorkoutPlan> workoutPlanOpt = workoutPlanRepository.findByName(planName);

        // Check if user exists
        if (!userOpt.isPresent()) {
            return "User with username: " + username + " not found.";
        }

        // Check if workoutPlan exists
        if (!workoutPlanOpt.isPresent()) {
            return "Workout plan with name: " + planName + " not found.";
        }

        // If both user and workout plan exist, assign the workout plan to the user
        User user = userOpt.get();
        WorkoutPlan workoutPlan = workoutPlanOpt.get();
        user.setWorkoutPlan(workoutPlan);

        // Save the changes
        userRepository.save(user);

        return "Workout plan "+planName+" assigned successfully to "+username;
    }

}
