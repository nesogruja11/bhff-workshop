package com.iot.fhtr.workshop.dto;

import java.util.List;

import com.iot.fhtr.workshop.model.MeasuringUnit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SensorDto {
	private int sensorId;
	private String sensorName;
	private List<MeasuringUnit> measuringUnits;
}
