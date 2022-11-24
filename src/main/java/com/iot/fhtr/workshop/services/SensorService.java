package com.iot.fhtr.workshop.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.fhtr.workshop.dto.Last10ChangesDto;
import com.iot.fhtr.workshop.dto.LastChangeDto;
import com.iot.fhtr.workshop.dto.SaveDataDto;
import com.iot.fhtr.workshop.dto.SensorDto;
import com.iot.fhtr.workshop.model.Measurements;
import com.iot.fhtr.workshop.model.Measuring;
import com.iot.fhtr.workshop.model.MeasuringUnit;
import com.iot.fhtr.workshop.model.Sensor;
import com.iot.fhtr.workshop.repository.SensorRepository;

@Service
public class SensorService {

	@Autowired
	SensorRepository sensorRepository;

	@Autowired
	MeasuringService measuringService;

	@Autowired
	MeasurementsService measurementsService;

	@Autowired
	MeasuringUnitService measuringUnitService;

	@Autowired
	SensorMeasuringUnitService sensorMeasuringUnitService;

	public List<LastChangeDto> findLastChange(Integer sensorId) throws Exception {
		List<LastChangeDto> lastChangeDtos = new ArrayList<LastChangeDto>();
		List<Measurements> measurementsList = new ArrayList<Measurements>();
		Sensor sensor = findById(sensorId);
		Measuring measuring = measuringService.findTopBySensorOrderByMeasuringIdDesc(sensor);
		measurementsList = measurementsService.findByMeasuring(measuring);
		measurementsList.forEach(x -> {
			lastChangeDtos.add(new LastChangeDto(x.getMeasuringUnit().getMeasuringUnitId(), x.getValue(),
					x.getMeasuringUnit().getMeasuringUnitName(), x.getMeasuringUnit().getMeasuringUnitLabel(),
					measuring.getDateTime()));
		});
		return lastChangeDtos;
	}

	public Last10ChangesDto findTop10BySensorId(Integer sensorId) throws Exception {
		Last10ChangesDto last10ChangesDto = new Last10ChangesDto();
		List<Measurements> measurementsList = measurementsService.findTop10BySensorId(sensorId);
		measurementsList.forEach(x -> {
			last10ChangesDto.getDateTime().add(x.getMeasuring().getDateTime());
			last10ChangesDto.getMeasuringUnitIds().add(x.getMeasuringUnit().getMeasuringUnitId());
			last10ChangesDto.getMeasuringUnitNames().add(x.getMeasuringUnit().getMeasuringUnitName());
			last10ChangesDto.getMeasuringUnitLabels().add(x.getMeasuringUnit().getMeasuringUnitLabel());
			last10ChangesDto.getValues().add(x.getValue());
		});
		return last10ChangesDto;
	}

	public Sensor findById(Integer sensorId) throws Exception {
		return sensorRepository.findById(sensorId)
				.orElseThrow(() -> new Exception("Nije pronađen senzor (sensorId:" + sensorId + ")!"));
	}

	public List<SensorDto> findAll() {
		List<SensorDto> sensorDtos = new ArrayList<SensorDto>();
		List<Sensor> sensors = sensorRepository.findAll();
		sensors.forEach(sensor -> {
			List<MeasuringUnit> measuringUnits = sensorMeasuringUnitService.findAllMeasuringUnitsBySensor(sensor);
			sensorDtos.add(new SensorDto(sensor.getSensorId(), sensor.getSensorName(), measuringUnits));
		});
		return sensorDtos;
	}

	public Measuring saveData(SaveDataDto saveDataDto) throws Exception {
		Sensor sensor = findById(saveDataDto.getSensorId());

		Measuring measuring = new Measuring();
		measuring.setDateTime(LocalDateTime.now());
		measuring.setSensor(sensor);
		measuringService.save(measuring);

		saveDataDto.getNewMeasureDtos().forEach(measure -> {
			Measurements measurements = new Measurements();
			measurements.setMeasuring(measuring);

			try {
				MeasuringUnit measuringUnit = measuringUnitService.findById(measure.getMeasuringUnitId());
				measurements.setMeasuringUnit(measuringUnit);
			} catch (Exception e) {
				e.printStackTrace();
			}

			measurements.setValue(measure.getValue());
			measurementsService.save(measurements);

		});

		return measuring;
	}
}
