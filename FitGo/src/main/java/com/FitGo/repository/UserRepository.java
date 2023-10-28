package com.FitGo.repository;

import com.FitGo.model.User;
import com.FitGo.model.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

public User findByUsername(String username);

        //User findBy_username(String username);
    public List<User> findByWorkoutPlan(WorkoutPlan workoutPlan);
}
