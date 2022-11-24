package com.iot.fhtr.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iot.fhtr.workshop.model.MeasuringUnit;

@Repository
public interface MeasuringUnitRepository extends JpaRepository<MeasuringUnit, Integer> {

}
