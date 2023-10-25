package com.FitGo.service.interfaces;




import com.FitGo.controller.DTO.WorkoutPlanResDTO;
import com.FitGo.model.WorkoutPlanExercise;

import java.util.List;

public interface IWPEService {

    public List<Object[]> getWorkoutPlanByUsername(String username);
    }
