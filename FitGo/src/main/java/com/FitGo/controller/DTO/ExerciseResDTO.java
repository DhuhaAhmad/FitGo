package com.FitGo.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ExerciseResDTO {
        private String exerciseName;
        private Integer repetitions;
        private Integer sets;
        private String muscleGroup;
        private String image;


}
