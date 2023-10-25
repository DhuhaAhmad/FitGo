package com.FitGo.controller.impl;


import com.FitGo.controller.interfaces.IExerciseController;
import com.FitGo.model.Exercise;
import com.FitGo.service.interfaces.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseController implements IExerciseController {

    @Autowired
    IExerciseService exerciseService;

    @Override
    @GetMapping("/exercises")
    @ResponseStatus(HttpStatus.OK)
    public List<Exercise> getAll() {

        return exerciseService.getAllExercises();
    }

    @Override
    @PostMapping("/add-exercise")
    @ResponseStatus(HttpStatus.CREATED)
    public void addExercise(@RequestBody Exercise exercise) {
        exerciseService.addExercise(exercise);
//        return ResponseEntity.ok("Successfully Added :)");

    }
}
