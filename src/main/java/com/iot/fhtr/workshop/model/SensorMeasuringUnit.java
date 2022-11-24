package com.iot.fhtr.workshop.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sensor_mesuring_unit")
public class SensorMeasuringUnit {

	@EmbeddedId
	@Column(name = "sensor_measuring_unit_id")
	private SensorMeasuringUnitKey sensorMeasuringUnitKey;

	@ManyToOne
	@MapsId("sensor_id")
	@JoinColumn(name = "sensor_id")
	private Sensor sensor;

	@ManyToOne
	@MapsId("measuring_unit_id")
	@JoinColumn(name = "measuring_unit_id")
	private MeasuringUnit measuringUnit;

}
