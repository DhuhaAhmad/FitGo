package com.FitGo.controller.impl;

import com.FitGo.controller.interfaces.IUserController;
import com.FitGo.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements IUserController {

    @Autowired
    IUserService userService;

    @Override
    @PutMapping("/assign-user-to-plan")
    public ResponseEntity<String> assignWorkoutToUser(@RequestParam String username,
                                                      @RequestParam String planName) {
        String result = userService.assignUserToWorkoutPlan(username, planName);

        if (result.contains("not found")) {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
