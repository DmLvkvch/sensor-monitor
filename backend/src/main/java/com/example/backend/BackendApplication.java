package com.example.backend;

import com.example.backend.data.entities.*;
import com.example.backend.data.repository.RoleRepository;
import com.example.backend.data.repository.SensorRepository;
import com.example.backend.data.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication(scanBasePackages = "com.example.backend", exclude = HibernateJpaAutoConfiguration.class)
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository, RoleRepository roleRepository,
                                  SensorRepository sensorRepository) {
        return (args) -> {
            Role viewer = new Role("Viewer");
            Role administrator = new Role("Administrator");
            roleRepository.save(viewer);
            roleRepository.save(administrator);
            repository.save(User.builder().username("DIMA").password("pass1").enabled(true).role(administrator).build());
            repository.save(User.builder().username("NE DIMA").password("pass2").enabled(true).role(viewer).build());
            SensorType type = new SensorType("HUMIDITY");
            SensorUnit unit = new SensorUnit("CELSIUS");
            for (int i = 0; i < 7; i++) {
                Sensor sensor = Sensor.builder().type(type)
                        .name(UUID.randomUUID().toString())
                        .model(UUID.randomUUID().toString())
                        .unit(unit)
                        .description(UUID.randomUUID().toString())
                        .location(UUID.randomUUID().toString())
                        .range(new SensorRange(5, 10)).build();
                sensorRepository.save(sensor);
            }

            SensorType type1 = new SensorType("PRESSURE");
            SensorUnit unit1 = new SensorUnit("BAR");
            for (int i = 0; i < 7; i++) {
                Sensor sensor = Sensor.builder().type(type1)
                        .name(UUID.randomUUID().toString())
                        .model(UUID.randomUUID().toString())
                        .unit(unit1)
                        .description(UUID.randomUUID().toString())
                        .location(UUID.randomUUID().toString())
                        .range(new SensorRange(5, 10)).build();
                sensorRepository.save(sensor);
            }
        };
    }
}
