package com.FitGo.controller.impl;

import com.FitGo.model.Exercise;
import com.FitGo.model.ExerciseCategory;
import com.FitGo.repository.ExerciseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
class ExerciseControllerTest {

    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    private Exercise exercise;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        exercise = new Exercise("Squat","Lower body exercise", ExerciseCategory.BodyBuilding);
    }

    @AfterEach
    public void tearDown() {

        exerciseRepository.delete(exercise);
    }


    @Test
    void getAllExercises_validRequest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/exercises"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Push up"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Exercise 1"));
    }




    @Test
    void saveExercise() throws Exception {

        String body = objectMapper.writeValueAsString(exercise);

     mockMvc.perform(post("/add-exercise").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
//        assertTrue(exerciseRepository.findAll().toString().contains("Squat"));
        Optional<Exercise> foundExercise = exerciseRepository.findByName("Squat");
        assertTrue(foundExercise.isPresent());

    }


}