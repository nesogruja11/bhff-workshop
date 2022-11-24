package com.iot.fhtr.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iot.fhtr.workshop.model.Sensor;
import com.iot.fhtr.workshop.model.SensorMeasuringUnit;
import com.iot.fhtr.workshop.model.SensorMeasuringUnitKey;

@Repository
public interface SensorMeasuringUnitRepository extends JpaRepository<SensorMeasuringUnit, SensorMeasuringUnitKey> {

	List<SensorMeasuringUnit> findBySensor(Sensor sensor);
}
