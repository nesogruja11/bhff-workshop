package com.iot.fhtr.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "sensor")
public class Sensor {

	@Id
	@Column(name = "sensor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sensorId;

	@Column(name = "sensor_name", nullable = false)
	private String sensorName;
}
