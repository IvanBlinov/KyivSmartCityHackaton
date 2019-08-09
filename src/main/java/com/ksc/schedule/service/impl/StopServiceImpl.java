package com.ksc.schedule.service.impl;

import com.ksc.schedule.entity.Stop;
import com.ksc.schedule.repository.StopRepository;
import com.ksc.schedule.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopServiceImpl implements StopService {

    @Autowired
    private StopRepository repository;

    @Override
    public Stop save(Stop stop) {
        return repository.save(stop);
    }

    @Override
    public void saveAll(List<Stop> stops) {
        repository.saveAll(stops);
    }

    @Override
    public Stop findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id) != null;
    }
}
