package com.FitGo.repository;

import com.FitGo.model.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@DataJpaTest
class WPERepositoryTest {


    @Autowired
     WPERepository wpeRepository;
    @Autowired
     ExerciseRepository exerciseRepository;
    @Autowired
     WorkoutPlanRepository workoutPlanRepository;

    @Autowired
     UserRepository userRepository;

      WorkoutPlan workoutPlan_test;
      Exercise exercise_test;
      WorkoutPlanExercise wpe_test;
       User user_test;


    @Test
    void findWorkoutPlanByUsername_test() {
        // Given
        exercise_test = new Exercise();
        exercise_test.setName("testExercise");
        exercise_test.setDescription("test");
        exercise_test.setCategory(ExerciseCategory.Cardio);
        exerciseRepository.save(exercise_test);
//        entityManager.persist(exercise);


        workoutPlan_test = new WorkoutPlan("testWorkoutPlan",8);
        workoutPlanRepository.save(workoutPlan_test);
        user_test = new User();
        user_test.setUsername("testUsername");
        user_test.setWorkoutPlan(workoutPlan_test);
        userRepository.save(user_test);


        wpe_test = new WorkoutPlanExercise();
        wpe_test.setExercise(exercise_test);
        wpe_test.setWorkoutPlan(workoutPlan_test);
        wpe_test.setRepetitions(10);
        wpe_test.setSets(3);
        wpeRepository.save(wpe_test);

        // When
        List<Object[]> result = wpeRepository.findWorkoutPlanByUsername("testUsername");

        // Then
        assertEquals(1, result.size());
        Object[] row = result.get(0);
        assertEquals("testExercise", row[0]);
        assertEquals(10, row[1]);
        assertEquals(3, row[2]);

    }

    @Test
    void findByWorkoutPlan_test() {
        Optional<WorkoutPlan> workoutPlanOptional = workoutPlanRepository.findByName("Fat lose");
        List<WorkoutPlanExercise> wpeList = wpeRepository.findByWorkoutPlan(workoutPlanOptional.get());
       String workoutPlanName =  wpeList.get(0).getWorkoutPlan().getName();
        assertEquals("Fat lose",workoutPlanName);
    }
}