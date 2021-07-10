package com.example.backend.data.repository;

import com.example.backend.data.entities.SensorUnit;

import java.util.List;

public interface SensorUnitRepository {
    List<SensorUnit> findAll();
}
