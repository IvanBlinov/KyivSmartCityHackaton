package com.ksc.schedule.service;

import com.ksc.schedule.entity.StopTime;
import com.ksc.schedule.entity.Trip;

import java.util.List;

public interface StopTimeService {

    StopTime save(StopTime stopTime);

    void saveAll(List<StopTime> stopTimes);

    boolean existsByTrip(Trip trip);
}
