package com.FitGo.controller.impl;

import com.FitGo.controller.interfaces.IUserController;
import com.FitGo.model.User;
import com.FitGo.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController implements IUserController {

    @Autowired
    IUserService userService;

    @Override
    @PutMapping("/assign-user-to-plan")
    public ResponseEntity<String> assignWorkoutToUser(
                                                      @RequestParam String planName) {
        String result = userService.assignUserToWorkoutPlan( planName);

        if (result.contains("not found")) {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }



    /**
     * Get a list of all users
     *
     * @return list of all users
     */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * Save a new user
     *
     * @param user the user to be saved
     */
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

}
