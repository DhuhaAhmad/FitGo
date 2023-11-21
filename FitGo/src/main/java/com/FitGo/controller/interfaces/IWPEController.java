package com.FitGo.controller.interfaces;

import com.FitGo.controller.DTO.UserWorkoutPlanResDTO;
import org.springframework.http.ResponseEntity;

public interface IWPEController {

    public ResponseEntity<UserWorkoutPlanResDTO> getWorkoutPlanByUsername(String username);
}
