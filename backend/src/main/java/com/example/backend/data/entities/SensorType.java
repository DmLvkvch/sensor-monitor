package com.example.backend.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SENSOR_TYPES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SensorType {
    @Id
    @Column(name = "sensor_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    public SensorType(String name) {
        this.name = name;
    }
}
