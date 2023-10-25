package com.FitGo.controller.interfaces;

import com.FitGo.model.Exercise;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IExerciseController {

    public List<Exercise> getAll();

    public void addExercise(Exercise exercise);
}
