package com.ksc.schedule.service;

import com.ksc.schedule.entity.Trip;

import java.util.List;

public interface TripService {

    Trip save(Trip trip);

    void saveAll(List<Trip> trips);

    Trip findById(String id);
    List<Trip> findByRouteId(String id);

    boolean existsById(String id);
}
