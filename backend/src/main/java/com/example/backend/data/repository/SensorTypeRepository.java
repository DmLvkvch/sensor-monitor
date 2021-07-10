package com.example.backend.data.repository;

import com.example.backend.data.entities.SensorType;

import java.util.List;

public interface SensorTypeRepository {
    List<SensorType> findAll();
}
