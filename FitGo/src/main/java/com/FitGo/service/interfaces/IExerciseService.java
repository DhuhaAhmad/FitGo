package com.FitGo.service.interfaces;

import com.FitGo.model.Exercise;

import java.util.List;

public interface IExerciseService {

    public List<Exercise> getAllExercises();

    public void addExercise(Exercise exercise);

}
