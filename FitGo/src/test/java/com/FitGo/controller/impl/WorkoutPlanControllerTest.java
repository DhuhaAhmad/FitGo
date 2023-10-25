package com.FitGo.controller.impl;

import com.FitGo.model.*;
import com.FitGo.repository.ExerciseRepository;
import com.FitGo.repository.UserRepository;
import com.FitGo.repository.WPERepository;
import com.FitGo.repository.WorkoutPlanRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class WorkoutPlanControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @Autowired
    WPERepository wpeRepository;
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    WorkoutPlanRepository workoutPlanRepository;

    @Autowired
    UserRepository userRepository;



    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        // Given
//        Exercise exercise_test = new Exercise();
//        exercise_test.setName("testExercise");
//        exercise_test.setDescription("test");
//        exercise_test.setCategory(ExerciseCategory.Cardio);
//        exerciseRepository.save(exercise_test);
//
//        WorkoutPlan workoutPlan_test = new WorkoutPlan("testWorkoutPlan",8);
//        workoutPlanRepository.save(workoutPlan_test);
//
//        User user_test = new User();
//        user_test.setUsername("testUsername");
//        user_test.setWorkoutPlan(workoutPlan_test);
//        userRepository.save(user_test);
//
//
//        WorkoutPlanExercise wpe_test = new WorkoutPlanExercise();
//        wpe_test.setExercise(exercise_test);
//        wpe_test.setWorkoutPlan(workoutPlan_test);
//        wpe_test.setRepetitions(10);
//        wpe_test.setSets(3);
//        System.out.println(wpe_test);
//        wpeRepository.save(wpe_test);

    }

    @Test
    void deleteWorkoutPlan_validRequest() throws Exception {

        mockMvc.perform(delete("/delete-workout-plan?name=My Workout Plan3"))
                .andExpect(status().isOk())
                .andReturn();

        assertFalse(workoutPlanRepository.findAll().toString().contains("My Workout Plan3"));
    }
}