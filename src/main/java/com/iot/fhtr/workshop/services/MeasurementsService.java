package com.iot.fhtr.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.fhtr.workshop.model.Measurements;
import com.iot.fhtr.workshop.model.Measuring;
import com.iot.fhtr.workshop.repository.MeasurementsRepository;

@Service
public class MeasurementsService {

	@Autowired
	MeasurementsRepository measurementsRepository;

	public List<Measurements> findByMeasuring(Measuring measuring) {
		return measurementsRepository.findByMeasuring(measuring);
	}

	public List<Measurements> findTop10BySensorId(Integer sensorId) {
		return measurementsRepository.findTop10BySensorId(sensorId);
	}

	public void save(Measurements measurements) {
		measurementsRepository.save(measurements);
	}
}
