package com.ksc.schedule.service.impl;

import com.ksc.schedule.entity.Trip;
import com.ksc.schedule.repository.TripRepository;
import com.ksc.schedule.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository repository;

    public Trip save(Trip trip) {
        return repository.save(trip);
    }
}
