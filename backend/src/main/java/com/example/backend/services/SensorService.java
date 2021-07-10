package com.example.backend.services;

import com.example.backend.data.entities.Sensor;
import com.example.backend.data.entities.SensorPage;

public interface SensorService {

    SensorPage getSensorsByPage(int page, String pattern);

    Sensor getSensorDetails(Long id);

    void updateSensor(Sensor sensor);

    void deleteSensor(Long id);

    void addSensor(Sensor sensor);

    SensorPage getSensorsByFilter(int page, String pattern);
}
