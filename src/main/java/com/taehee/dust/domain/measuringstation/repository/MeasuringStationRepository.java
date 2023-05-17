package com.taehee.dust.domain.measuringstation.repository;

import com.taehee.dust.domain.location.model.Location;
import com.taehee.dust.domain.measuringstation.model.MeasuringStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasuringStationRepository extends JpaRepository<MeasuringStation, Integer> {

    List<MeasuringStation> findAllByLocationOrderByNameAsc(Location location);
}
