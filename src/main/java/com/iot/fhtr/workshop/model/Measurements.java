package com.iot.fhtr.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "measurements")
public class Measurements {

	@Id
	@Column(name = "measurements_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int measurementsId;

	@ManyToOne
	@JoinColumn(name = "measuring_id", nullable = false)
	private Measuring measuring;

	@ManyToOne
	@JoinColumn(name = "measuring_unit_id", nullable = false)
	private MeasuringUnit measuringUnit;

	private float value;
}
