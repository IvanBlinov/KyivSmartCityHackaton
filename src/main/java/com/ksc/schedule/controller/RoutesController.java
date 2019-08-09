package com.ksc.schedule.controller;

import com.ksc.schedule.constants.UrlMapping;
import com.ksc.schedule.dto.RouteDto;
import com.ksc.schedule.dto.RouteListDto;
import com.ksc.schedule.entity.Route;
import com.ksc.schedule.entity.StopTime;
import com.ksc.schedule.mapper.DozerMapper;
import com.ksc.schedule.service.RouteService;
import com.ksc.schedule.service.StopTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RoutesController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private StopTimeService stopTimeService;

    @Autowired
    private DozerMapper mapper;

    @GetMapping(UrlMapping.ROUTES)
    public List<RouteListDto> getRoutes() {
        List<Route> dbRoutes = routeService.getAllRoutes();
        List<StopTime> stopTimes = stopTimeService.findAll().stream().limit(5000).collect(Collectors.toList());
        List<RouteListDto> routeList = new ArrayList<>();
        for (Route route : dbRoutes) {
            List<StopTime> tripStops = stopTimes.stream().filter(stopTime -> stopTime.getTrip().getRoute() == route).collect(Collectors.toList());
            if (tripStops == null || tripStops.isEmpty()) continue;
            StopTime max = tripStops.get(0), min = tripStops.get(0);
            for (StopTime stopTime : tripStops) {
                if (stopTime.getDeparture().compareTo(max.getDeparture()) > 0) {
                    max = stopTime;
                }
                if (stopTime.getDeparture().compareTo(min.getDeparture()) < 0) {
                    min = stopTime;
                }
            }
            RouteListDto routeListDto = new RouteListDto();
            routeListDto.setDepStation(min.getStop().getName());
            routeListDto.setDeparture(min.getDeparture());
            routeListDto.setArrStation(max.getStop().getName());
            routeListDto.setArrival(max.getArrival());
            routeListDto.setTransportNumber(route.getId().substring(1));
            routeList.add(routeListDto);
        }
        routeList.sort(Comparator.comparing(RouteListDto::getDeparture));
        return routeList;
    }

    @GetMapping(UrlMapping.ROUTES_BUS)
    public List<RouteDto> getBusRoutes() {
        List<Route> dbBusRoutes = routeService.getBusRoutes();
        return mapper.mapList(dbBusRoutes, RouteDto.class);
    }

    @GetMapping(UrlMapping.ROUTES_TROLLEYBUS)
    public List<RouteDto> getTrolleybusRoutes() {
        List<Route> dbBusRoutes = routeService.getTrolleybusRoutes();
        return mapper.mapList(dbBusRoutes, RouteDto.class);
    }

    @GetMapping(UrlMapping.ROUTES_TRAMWAY)
    public List<RouteDto> getTramwayRoutes() {
        List<Route> dbBusRoutes = routeService.getTramwayRoutes();
        return mapper.mapList(dbBusRoutes, RouteDto.class);
    }
}
