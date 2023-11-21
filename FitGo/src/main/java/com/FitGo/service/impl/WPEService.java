package com.FitGo.service.impl;

import com.FitGo.repository.WPERepository;
import com.FitGo.service.interfaces.IWPEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WPEService implements IWPEService {

    @Autowired
    WPERepository wpeRepository;

    @Override
    public List<Object[]> getWorkoutPlanByUsername(String username) {
        return wpeRepository.findWorkoutPlanByUsername(username);


    }
}
