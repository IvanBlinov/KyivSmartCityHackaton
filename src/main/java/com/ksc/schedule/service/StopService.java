package com.ksc.schedule.service;

import com.ksc.schedule.entity.Stop;

import java.util.List;

public interface StopService {

    Stop save(Stop stop);

    void saveAll(List<Stop> stops);

    Stop findById(String id);

    boolean existsById(String id);

    List<Stop> findNearestStations(String lat, String lon);

    List<Stop> findAll();
}
