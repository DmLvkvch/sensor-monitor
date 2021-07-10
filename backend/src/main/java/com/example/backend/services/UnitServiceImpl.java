package com.example.backend.services;

import com.example.backend.data.entities.SensorUnit;
import com.example.backend.data.repository.SensorUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private SensorUnitRepository unitRepository;

    @Override
    public List<SensorUnit> getAllUnits() {
        return unitRepository.findAll();
    }
}
