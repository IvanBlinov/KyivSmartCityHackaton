package com.ksc.schedule.service.impl;

import com.ksc.schedule.entity.Route;
import com.ksc.schedule.repository.RouteRepository;
import com.ksc.schedule.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository repository;

    @Override
    public Route save(Route route) {
        return repository.save(route);
    }
}
