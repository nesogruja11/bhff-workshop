package com.iot.fhtr.workshop.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LastChangeDto {
	private int measuringUnitId;
	private float value;
	private String measuringUnit;
	private String measuringUnitLabel;
	private LocalDateTime dateTime;
}
