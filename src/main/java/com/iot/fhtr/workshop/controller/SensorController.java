package com.iot.fhtr.workshop.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iot.fhtr.workshop.dto.LastChangeDto;
import com.iot.fhtr.workshop.dto.SaveDataDto;
import com.iot.fhtr.workshop.dto.SensorDto;
import com.iot.fhtr.workshop.model.Measuring;
import com.iot.fhtr.workshop.services.SensorService;

@RestController
@RequestMapping("/sensor")
public class SensorController {

	@Autowired
	SensorService sensorService;

	@PostMapping("/save-data")
	public Measuring saveData(@RequestBody SaveDataDto saveDataDto) throws Exception {
		return sensorService.saveData(saveDataDto);
	}

	@GetMapping("/last-change")
	public List<LastChangeDto> findLastChange(@RequestParam Integer sensorId) throws Exception {
		return sensorService.findLastChange(sensorId);
	}

	@GetMapping("/last-10-changes")
	public Collection<HashMap<Object, Object>> findTop10BySensorId(@RequestParam Integer sensorId) throws Exception {
		return sensorService.findTop10BySensorId(sensorId);
	}

	@GetMapping("/find-all")
	public List<SensorDto> findAll() {
		return sensorService.findAll();
	}

	@GetMapping
	public SensorDto findById(@RequestParam Integer sensorId) throws Exception {
		return sensorService.findSensorById(sensorId);
	}
}
