package com.FitGo.repository;

import com.FitGo.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

//    public List<Exercise> findAll();
    public Optional<Exercise> findByName(String name);

}
