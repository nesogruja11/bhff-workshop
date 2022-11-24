package com.iot.fhtr.workshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SensorMeasuringUnitKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "sensor_id", nullable = false)
	private int sensorId;

	@Column(name = "measuring_unit_id", nullable = false)
	private int measuringUnitId;
}
