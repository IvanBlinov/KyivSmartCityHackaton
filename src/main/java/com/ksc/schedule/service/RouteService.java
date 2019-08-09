package com.ksc.schedule.service;

import com.ksc.schedule.entity.Route;

import java.util.List;

public interface RouteService {

    Route save(Route route);
    void saveAll(List<Route> routes);

    Route findById(String id);

    boolean existsById(String id);
}
