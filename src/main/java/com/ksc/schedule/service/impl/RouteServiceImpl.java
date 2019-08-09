package com.ksc.schedule.service.impl;

import com.ksc.schedule.entity.Route;
import com.ksc.schedule.repository.RouteRepository;
import com.ksc.schedule.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository repository;

    @Override
    public Route save(Route route) {
        return repository.save(route);
    }

    @Override
    public void saveAll(List<Route> routes) {
        repository.saveAll(routes);
    }

    @Override
    public Route findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id) != null;
    }

    @Override
    public Route findRouteByBusNumber(String number) {
        List<Route> routes = repository.findByShortName(number);
        if (routes == null || routes.isEmpty()) {
            return null;
        }
        return routes.get(0);
    }

    @Override
    public List<Route> getAllRoutes() {
        return repository.findAll();
    }

    @Override
    public List<Route> getBusRoutes() {
        return repository.findByIdStartsWith("A");
    }

    @Override
    public List<Route> getTrolleybusRoutes() {
        return repository.findByIdStartsWith("B");
    }

    @Override
    public List<Route> getTramwayRoutes() {
        return repository.findByIdStartsWith("C");
    }
}
