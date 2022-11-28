package com.iot.fhtr.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.fhtr.workshop.model.Measuring;
import com.iot.fhtr.workshop.model.Sensor;
import com.iot.fhtr.workshop.repository.MeasuringRepository;

@Service
public class MeasuringService {

	@Autowired
	MeasuringRepository measuringRepository;

	public Optional<Measuring> findTopBySensorOrderByMeasuringIdDesc(Sensor sensor) throws Exception {
		return measuringRepository.findTopBySensorOrderByMeasuringIdDesc(sensor);
	}

	public List<Measuring> findTop10BySensorOrderByMeasuringIdDesc(Sensor sensor) throws Exception {
		return measuringRepository.findTop10BySensorOrderByMeasuringIdDesc(sensor);
	}

	public void save(Measuring measuring) {
		measuringRepository.save(measuring);
	}
}
