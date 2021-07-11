package com.example.backend.services;

import com.example.backend.data.entities.Sensor;
import com.example.backend.data.entities.SensorPage;

public interface SensorService {

    SensorPage getDataByPage(int page, String pattern);

    Sensor getDetails(Long id);

    void update(Sensor sensor);

    void delete(Long id);

    void add(Sensor sensor);
}
