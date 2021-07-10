package com.example.backend.controllers;

import com.example.backend.data.entities.Sensor;
import com.example.backend.data.entities.SensorPage;
import com.example.backend.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
public class SensorApiController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("")
    public SensorPage getSensorPage(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                    @RequestParam(name = "search", required = false, defaultValue = "") String searchPattern) {
        return sensorService.getSensorsByPage(page, searchPattern);
    }

    @GetMapping("{id}")
    public Sensor getSensorDetails(@PathVariable(name = "id") Long id) {
        return sensorService.getSensorDetails(id);
    }

    @PostMapping("")
    public void updateSensor(@RequestBody Sensor sensor) {
        System.out.println(sensor);
        sensorService.updateSensor(sensor);
    }

    @DeleteMapping("{id}")
    public void deleteSensor(@PathVariable(name = "id") Long id) {
        sensorService.deleteSensor(id);
    }

    @PutMapping("")
    public void addSensor(@RequestBody Sensor sensor) {
        sensorService.addSensor(sensor);
    }
}
