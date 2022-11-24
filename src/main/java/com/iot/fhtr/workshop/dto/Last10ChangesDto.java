package com.iot.fhtr.workshop.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Last10ChangesDto {
	private List<String> measuringUnitNames = new ArrayList<String>();
	private List<String> measuringUnitLabels = new ArrayList<String>();
	private List<Integer> measuringUnitIds = new ArrayList<Integer>();
	private List<Float> values = new ArrayList<Float>();
	private List<LocalDateTime> dateTime = new ArrayList<LocalDateTime>();
}
