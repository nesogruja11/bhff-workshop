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
@Table(name = "measuring_unit")
public class MeasuringUnit {

	@Id
	@Column(name = "measuring_unit_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int measuringUnitId;

	@Column(name = "measuring_unit_name", nullable = false)
	private String measuringUnitName;

	@Column(name = "measuring_unit_label", nullable = false)
	private String measuringUnitLabel;
}
