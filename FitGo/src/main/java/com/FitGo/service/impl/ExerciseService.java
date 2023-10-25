package com.FitGo.service.impl;

import com.FitGo.model.Exercise;
import com.FitGo.repository.ExerciseRepository;
import com.FitGo.service.interfaces.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService implements IExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> getAllExercises() {

        return exerciseRepository.findAll();

    }

    @Override
    public void addExercise(Exercise exercise) {
         exerciseRepository.save(exercise);
    }
}
