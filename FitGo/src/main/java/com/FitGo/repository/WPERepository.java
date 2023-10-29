package com.FitGo.repository;

import com.FitGo.controller.DTO.WorkoutPlanResDTO;
import com.FitGo.model.Exercise;
import com.FitGo.model.User;
import com.FitGo.model.WorkoutPlan;
import com.FitGo.model.WorkoutPlanExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WPERepository extends JpaRepository<WorkoutPlanExercise,Integer> {

//    public List<WorkoutPlanExercise> findByWorkoutPlanId(Integer id);

    @Query(value = "SELECT e.name, wpe.repetitions, wpe.sets " +
            "FROM Exercise e " +
            "JOIN Workout_plan_exercise wpe ON e.id = wpe.exercise_id " +
            "JOIN Workout_plan wp ON wp.id = wpe.workout_plan_id " +
            "JOIN User u ON wp.id = u.workout_plan_id " +
            "WHERE u.username = :username",nativeQuery = true)

    public List<Object[]> findWorkoutPlanByUsername(@Param("username") String username);

    List<WorkoutPlanExercise> findByWorkoutPlan(WorkoutPlan workoutPlan);


}
