package com.taehee.dust.domain.location.repository;

import com.taehee.dust.domain.location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    Optional<Location> findByName(String locationName);
}
