package com.example.backend.data.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SENSORS")
@EqualsAndHashCode
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String model;
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "from", column = @Column(name = "range_from")),
            @AttributeOverride(name = "to", column = @Column(name = "range_to"))
    })
    private SensorRange range;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_type_id", nullable = false)
    private SensorType type;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_unit_id", nullable = false)
    private SensorUnit unit;
    private String location;
    private String description;
}
