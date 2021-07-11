package com.example.backend.data.repository;

import com.example.backend.data.entities.Sensor;

import java.util.List;

public interface SensorRepository {

    long getCount(String pattern);

    void save(Sensor sensor);

    void update(Sensor sensor);

    List<Sensor> findAll(int page, String pattern);

    Sensor findById(Long id);

    void deleteById(Long id);

}
