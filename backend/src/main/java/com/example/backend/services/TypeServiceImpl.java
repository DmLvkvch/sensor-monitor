package com.example.backend.services;

import com.example.backend.data.entities.SensorType;
import com.example.backend.data.repository.SensorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private SensorTypeRepository typeRepository;

    @Override
    public List<SensorType> getData() {
        return typeRepository.findAll();
    }
}
