package com.ksc.schedule.repository;

import com.ksc.schedule.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, String> {

    List<Trip> findByRouteId(String routeId);
}
