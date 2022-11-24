package com.iot.fhtr.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iot.fhtr.workshop.model.Measurements;
import com.iot.fhtr.workshop.model.Measuring;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurements, Integer> {

	List<Measurements> findByMeasuring(Measuring measuring);

	@Query(value = "select * from measurements \r\n"
			+ "join measuring on measuring.measuring_id = measurements.measuring_id\r\n"
			+ "where sensor_id =?1 order by measurements.measuring_id desc limit 10", nativeQuery = true)
	List<Measurements> findTop10BySensorId(Integer sensorId);
}
