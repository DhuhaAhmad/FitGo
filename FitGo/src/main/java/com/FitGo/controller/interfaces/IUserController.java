package com.FitGo.controller.interfaces;

import com.FitGo.model.User;
import com.FitGo.model.WorkoutPlan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {

    public ResponseEntity<String> assignWorkoutToUser(String planName);

    /**
     * Retrieves a list of all users
     *
     * @return list of all users
     */
    List<User> getUsers();

    /**
     * Saves a new user
     *
     * @param user the user to be saved
     * @return the saved user
     */
    User saveUser(User user);

}
