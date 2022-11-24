package com.iot.fhtr.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iot.fhtr.workshop.model.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

}
