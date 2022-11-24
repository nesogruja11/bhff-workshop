package com.iot.fhtr.workshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iot.fhtr.workshop.model.Measuring;
import com.iot.fhtr.workshop.model.Sensor;

@Repository
public interface MeasuringRepository extends JpaRepository<Measuring, Integer> {

	Optional<Measuring> findTopBySensorOrderByMeasuringIdDesc(Sensor sensor);

	List<Measuring> findTop10BySensorOrderByMeasuringIdDesc(Sensor sensor);

}
