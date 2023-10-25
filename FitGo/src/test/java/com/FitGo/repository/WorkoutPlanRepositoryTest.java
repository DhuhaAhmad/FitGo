package com.FitGo.repository;

import com.FitGo.model.Exercise;
import com.FitGo.model.ExerciseCategory;
import com.FitGo.model.WorkoutPlan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorkoutPlanRepositoryTest {


    @Autowired
    WorkoutPlanRepository workoutPlanRepository;
    @Test
    void findByName() {

        Optional<WorkoutPlan> workoutPlanOptional = workoutPlanRepository.findByName("Fat lose");
        assertEquals("Fat lose", workoutPlanOptional.get().getName());
        assertEquals(6, workoutPlanOptional.get().getDuration());

    }
}