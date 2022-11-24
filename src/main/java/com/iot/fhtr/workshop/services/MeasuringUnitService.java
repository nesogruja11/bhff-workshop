package com.iot.fhtr.workshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.fhtr.workshop.model.MeasuringUnit;
import com.iot.fhtr.workshop.repository.MeasuringUnitRepository;

@Service
public class MeasuringUnitService {

	@Autowired
	MeasuringUnitRepository measuringUnitRepository;

	public MeasuringUnit findById(Integer measuringUnitId) throws Exception {
		return measuringUnitRepository.findById(measuringUnitId).orElseThrow(
				() -> new Exception("Nije pronađena mjerna jedinica (measuringUnitId:" + measuringUnitId + ")!"));
	}
}
