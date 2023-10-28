package com.FitGo.repository;



import com.FitGo.model.Exercise;
import com.FitGo.model.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan,Integer> {

    public Optional<WorkoutPlan> findByName(String name);

    @Query(value = "SELECT \n" +
            "    e.name AS exercise_name,\n" +
            "    wpe.repetitions,\n" +
            "    wpe.sets,\n" +
            "    wp.id,\n" +
            "    wp.name,\n" +
            "    wp.duration\n" +
            "FROM \n" +
            "    workout_plan_exercise wpe\n" +
            "JOIN \n" +
            "    exercise e ON wpe.exercise_id = e.id\n" +
            "JOIN \n" +
            "    workout_plan wp ON wpe.workout_plan_id = wp.id",nativeQuery = true)
    List<Object[]> findAllWithExercises();


}
