package com.iot.fhtr.workshop.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveDataDto {
	public Integer sensorId;
	public List<NewMeasureDto> newMeasureDtos;
}
