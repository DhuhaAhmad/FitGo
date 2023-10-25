package com.FitGo.repository;



import com.FitGo.model.Exercise;
import com.FitGo.model.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan,Integer> {

    public Optional<WorkoutPlan> findByName(String name);
}
