package com.FitGo.controller.interfaces;

import com.FitGo.model.User;
import com.FitGo.model.WorkoutPlan;
import org.springframework.http.ResponseEntity;

public interface IUserController {

    public ResponseEntity<String> assignWorkoutToUser(String username,String planName);
}
