package com.example.backend.controllers;

import com.example.backend.data.entities.SensorType;
import com.example.backend.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sensors/types")
public class SensorTypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("")
    public List<SensorType> getUnits() {
        return typeService.getData();
    }
}
