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
        return sensorService.getDataByPage(page, searchPattern);
    }

    @GetMapping("{id}")
    public Sensor getDetails(@PathVariable(name = "id") Long id) {
        return sensorService.getDetails(id);
    }

    @PostMapping("")
    public void update(@RequestBody Sensor sensor) {
        sensorService.update(sensor);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        sensorService.delete(id);
    }

    @PutMapping("")
    public void add(@RequestBody Sensor sensor) {
        sensorService.add(sensor);
    }
}
