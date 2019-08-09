package com.ksc.schedule.controller;

import com.ksc.schedule.constants.UrlMapping;
import com.ksc.schedule.entity.Trip;
import com.ksc.schedule.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @Transactional
    @GetMapping(UrlMapping.TRIP_BY_ID)
    public Trip getTripById(@PathVariable("id") String id) {
        return tripService.findById(id);
    }

    @Transactional
    @GetMapping(UrlMapping.TRIP_BY_ROUTE_ID)
    public List<Trip> getTripByRouteId(@PathVariable("id") String id) {
        return tripService.findByRouteId(id);
    }
}
