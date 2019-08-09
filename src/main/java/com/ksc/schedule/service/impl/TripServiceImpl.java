package com.ksc.schedule.service.impl;

import com.ksc.schedule.entity.Trip;
import com.ksc.schedule.repository.TripRepository;
import com.ksc.schedule.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository repository;

    public Trip save(Trip trip) {
        return repository.save(trip);
    }

    @Override
    public void saveAll(List<Trip> trips) {
        repository.saveAll(trips);
    }

    @Override
    public Trip findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Trip> findByRouteId(String id) {
        return repository.findByRouteId(id);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id) != null;
    }
}
