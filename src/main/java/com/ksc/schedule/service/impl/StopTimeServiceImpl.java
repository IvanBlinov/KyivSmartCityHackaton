package com.ksc.schedule.service.impl;

import com.ksc.schedule.entity.StopTime;
import com.ksc.schedule.entity.Trip;
import com.ksc.schedule.repository.StopTimeRepository;
import com.ksc.schedule.service.StopTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopTimeServiceImpl implements StopTimeService {

    @Autowired
    private StopTimeRepository repository;

    @Override
    public StopTime save(StopTime stopTime) {
        return repository.save(stopTime);
    }

    @Override
    public void saveAll(List<StopTime> stopTimes) {
        repository.saveAll(stopTimes);
    }

    public StopTime findByTrip(Trip trip) {
        return repository.findByTrip(trip).orElse(null);
    }

    @Override
    public boolean existsByTrip(Trip trip) {
        return findByTrip(trip) != null;
    }
}
