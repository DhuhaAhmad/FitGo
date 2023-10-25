package com.FitGo.repository;

import com.FitGo.model.Exercise;
import com.FitGo.model.ExerciseCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExerciseRepositoryTest {

    @Autowired
    ExerciseRepository exerciseRepository;
    @Test
    void findAll() {
        List<Exercise> exerciseList = exerciseRepository.findAll();
        assertEquals(11, exerciseList.size());

    }

    @Test
    void findByName() {
        Optional<Exercise> exerciseOptional = exerciseRepository.findByName("Push up");
        assertEquals(ExerciseCategory.Strength, exerciseOptional.get().getCategory());
        assertEquals("upper body exercise", exerciseOptional.get().getDescription());
    }
}