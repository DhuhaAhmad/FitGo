package com.FitGo.service.impl;

import com.FitGo.controller.DTO.AllWorkoutPlanDTO;
import com.FitGo.controller.DTO.ExerciseDetailDTO;
import com.FitGo.controller.DTO.ExerciseResDTO;
import com.FitGo.controller.DTO.WorkoutPlanReqDTO;
import com.FitGo.model.*;
import com.FitGo.repository.ExerciseRepository;
import com.FitGo.repository.UserRepository;
import com.FitGo.repository.WPERepository;
import com.FitGo.repository.WorkoutPlanRepository;
import com.FitGo.service.interfaces.IWorkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class WorkoutPlanService implements IWorkPlanService {

    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    WorkoutPlanRepository workoutPlanRepository;
    @Autowired
    WPERepository wpeRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public WorkoutPlan createWorkoutPlan(WorkoutPlanReqDTO workoutPlanReqDTO) {
        System.out.println(workoutPlanReqDTO);
        WorkoutPlan workoutPlan = new WorkoutPlan(workoutPlanReqDTO.getName(), workoutPlanReqDTO.getDuration());
        workoutPlan = workoutPlanRepository.save(workoutPlan);

        for (ExerciseDetailDTO detailDTO : workoutPlanReqDTO.getExercises()) {
            System.out.println(detailDTO.getExerciseName());
            Exercise exercise = exerciseRepository.findByName(detailDTO.getExerciseName()).orElseThrow(() -> new RuntimeException("Exercise not found"));
            WorkoutPlanExercise wpe = new WorkoutPlanExercise();
            wpe.setExercise(exercise);
            wpe.setWorkoutPlan(workoutPlan);
            wpe.setRepetitions(detailDTO.getRepetitions());
            wpe.setSets(detailDTO.getSets());
            wpeRepository.save(wpe);
        }

        return workoutPlan;
    }


    public String updateWorkoutPlan(WorkoutPlanReqDTO workoutPlanReqDTO) {

        // Fetch the existing workout plan
        Optional<WorkoutPlan> workoutPlanOptional = workoutPlanRepository.findByName(workoutPlanReqDTO.getName());
        if (workoutPlanOptional.isPresent()) {
            WorkoutPlan workoutPlan = workoutPlanOptional.get();
            workoutPlan.setDuration(workoutPlanReqDTO.getDuration());
            workoutPlan = workoutPlanRepository.save(workoutPlan);

            for (ExerciseDetailDTO detailDTO : workoutPlanReqDTO.getExercises()) {
                System.out.println(detailDTO.getExerciseName());
                Exercise newExercise;

                Optional<Exercise> newExerciseOp = exerciseRepository.findByName(detailDTO.getExerciseName());
                if (newExerciseOp.isEmpty()) return "Exercise "+ detailDTO.getExerciseName()+" not found";
                else {
                    newExercise = newExerciseOp.get();
                }



                List<WorkoutPlanExercise> existingWPEList = wpeRepository.findByWorkoutPlan(workoutPlan);
                boolean exerciseFound = false;

                for (WorkoutPlanExercise wpe : existingWPEList) {
                    if (wpe.getExercise().getId().equals(newExercise.getId())) {
                        // Update the WorkoutPlanExercise if the exercise matches
                        wpe.setRepetitions(detailDTO.getRepetitions());
                        wpe.setSets(detailDTO.getSets());
                        wpeRepository.save(wpe);
                        exerciseFound = true;
                        break;
                    }
                }

                if (!exerciseFound && !existingWPEList.isEmpty()) {
                    // If the new exercise isn't found among the existing associations
                    // and there are some existing associations, update the first one with the new exercise.
                    WorkoutPlanExercise wpe = existingWPEList.get(0); // Get the first existing association
                    wpe.setExercise(newExercise);
                    wpe.setRepetitions(detailDTO.getRepetitions());
                    wpe.setSets(detailDTO.getSets());
                    wpeRepository.save(wpe);
                } else if (!exerciseFound) {
                    // If there are no existing associations, just create a new one.
                    WorkoutPlanExercise wpe = new WorkoutPlanExercise();
                    wpe.setExercise(newExercise);
                    wpe.setRepetitions(detailDTO.getRepetitions());
                    wpe.setSets(detailDTO.getSets());
                    wpe.setWorkoutPlan(workoutPlan);
                    wpeRepository.save(wpe);
                }
            }
            return "WorkoutPlan updated successfully!";
        } else {
            return "Workout Plan not found";
        }
    }


    @Override
    public String deleteWorkoutPlanByName(String name) {

        Optional<WorkoutPlan> workoutPlanOptional = workoutPlanRepository.findByName(name);

        if(workoutPlanOptional.isPresent()) {
            WorkoutPlan workoutPlan = workoutPlanOptional.get();

            // First, set workout_plan_id to NULL in user table for all users who have this workout plan
            List<User> users = userRepository.findByWorkoutPlan(workoutPlan);
            for (User user : users) {
                user.setWorkoutPlan(null);
                userRepository.save(user);
            }

            // Now, remove all associations of this WorkoutPlan with exercises
            List<WorkoutPlanExercise> wpeList = wpeRepository.findByWorkoutPlan(workoutPlan);
            if (!wpeList.isEmpty()) {
                wpeRepository.deleteAll(wpeList);
            }

            workoutPlanRepository.delete(workoutPlan);
            return "Workout Plan " + name + " deleted successfully!";
        }

        return "Workout Plan " + name + " not found";
    }

    @Override

    public List<AllWorkoutPlanDTO> showAllWorkoutPlans() {
        List<Object[]> resultList = workoutPlanRepository.findAllWithExercises();
        System.out.println(resultList);
        Map<Integer, AllWorkoutPlanDTO> workoutPlanMap = new HashMap<>();
        for (Object[] row : resultList) {
            String exerciseName = (String) row[0];
            String muscleGroup = (String) row[1];
            String image = (String) row[2];
            Integer repetitions = (Integer) row[3];
            Integer sets = (Integer) row[4];
            Integer workoutPlanId = (Integer) row[5];
            String workoutPlanName = (String) row[6];
            Integer workoutPlanDuration = (Integer) row[7];

            AllWorkoutPlanDTO allWorkoutPlanDTO = workoutPlanMap.computeIfAbsent(workoutPlanId, id -> {
                AllWorkoutPlanDTO dto = new AllWorkoutPlanDTO();
                dto.setName(workoutPlanName);
                dto.setDuration(workoutPlanDuration);
                return dto;
            });

            ExerciseResDTO exerciseDetailsDTO = new ExerciseResDTO(exerciseName, repetitions, sets,muscleGroup,image);

                allWorkoutPlanDTO.addExerciseDetail(exerciseDetailsDTO);
        }

        return new ArrayList<>(workoutPlanMap.values());
    }

}
