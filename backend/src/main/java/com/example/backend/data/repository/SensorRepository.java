package com.example.backend.data.repository;

import com.example.backend.data.entities.Sensor;

import java.util.List;

public interface SensorRepository {

    long getCount();

    long getCountByFilter(String pattern);

    void save(Sensor sensor);

    void update(Sensor sensor);

    List<Sensor> findAll(int page);

    Sensor findById(Long id);

    void deleteById(Long id);

    List<Sensor> findByFilter(int page, String pattern);

}
