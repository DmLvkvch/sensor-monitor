package com.example.backend.controllers;

import com.example.backend.data.entities.SensorUnit;
import com.example.backend.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sensors/units")
public class SensorUnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping("")
    public List<SensorUnit> getUnits() {
        return unitService.getAllUnits();
    }
}
