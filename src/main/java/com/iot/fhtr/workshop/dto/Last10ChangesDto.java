package com.iot.fhtr.workshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Last10ChangesDto {
	private Integer measuringId;
	private String measuringUnitName;
	private String measuringUnitLabel;
	private Float value;

}
