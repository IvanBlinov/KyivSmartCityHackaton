package com.ksc.schedule.controller;

import com.ksc.schedule.constants.UrlMapping;
import com.ksc.schedule.dto.TripDto;
import com.ksc.schedule.entity.Trip;
import com.ksc.schedule.mapper.DozerMapper;
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

    @Autowired
    private DozerMapper mapper;

    @Transactional
    @GetMapping(UrlMapping.TRIP_BY_ID)
    public TripDto getTripById(@PathVariable("id") String id) {
        Trip dbTrip = tripService.findById(id);
        return mapper.map(dbTrip, TripDto.class);
    }

    @Transactional
    @GetMapping(UrlMapping.TRIP_BY_ROUTE_ID)
    public List<TripDto> getTripByRouteId(@PathVariable("id") String routeId) {
        List<Trip> dbTrips = tripService.findByRouteId(routeId);
        return mapper.mapList(dbTrips, TripDto.class);
    }
}
