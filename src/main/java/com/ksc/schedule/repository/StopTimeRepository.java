package com.ksc.schedule.repository;

import com.ksc.schedule.entity.StopTime;
import com.ksc.schedule.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StopTimeRepository extends JpaRepository<StopTime, String> {

    Optional<StopTime> findByTrip(Trip trip);
    List<StopTime> findAllByTripIn(List<Trip> trip);
}
