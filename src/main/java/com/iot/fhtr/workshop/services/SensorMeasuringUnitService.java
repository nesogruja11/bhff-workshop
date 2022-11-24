package com.iot.fhtr.workshop.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.fhtr.workshop.model.MeasuringUnit;
import com.iot.fhtr.workshop.model.Sensor;
import com.iot.fhtr.workshop.model.SensorMeasuringUnit;
import com.iot.fhtr.workshop.repository.SensorMeasuringUnitRepository;

@Service
public class SensorMeasuringUnitService {

	@Autowired
	SensorMeasuringUnitRepository sensorMeasuringUnitRepository;

	public List<MeasuringUnit> findAllMeasuringUnitsBySensor(Sensor sensor) {
		List<SensorMeasuringUnit> sensorMeasuringUnits = sensorMeasuringUnitRepository.findBySensor(sensor);
		List<MeasuringUnit> measuringUnits = new ArrayList<MeasuringUnit>();
		sensorMeasuringUnits.forEach(sensorMeasuringUnit -> {
			measuringUnits.add(sensorMeasuringUnit.getMeasuringUnit());
		});
		return measuringUnits;
	}
}
