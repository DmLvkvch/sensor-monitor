package com.example.backend.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SENSOR_UNITS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SensorUnit {
    @Id
    @Column(name = "sensor_unit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    public SensorUnit(String name) {
        this.name = name;
    }
}