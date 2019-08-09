package com.ksc.schedule.service;

import com.ksc.schedule.entity.Route;
import com.ksc.schedule.entity.Trip;

import java.util.List;

public interface TripService {

    Trip save(Trip trip);

    void saveAll(List<Trip> trips);

    Trip findById(String id);
    List<Trip> findByRouteId(String id);
    List<Trip> findByRoutes(List<Route> routes);

    boolean existsById(String id);
}
