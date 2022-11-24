package com.iot.fhtr.workshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewMeasureDto {

	private Integer measuringUnitId;
	private Float value;
}
