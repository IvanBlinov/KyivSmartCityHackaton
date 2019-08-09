package com.ksc.schedule.controller;

import com.ksc.schedule.constants.UrlMapping;
import com.ksc.schedule.dto.BusesStationDto;
import com.ksc.schedule.dto.StopDto;
import com.ksc.schedule.entity.Route;
import com.ksc.schedule.entity.Stop;
import com.ksc.schedule.entity.StopTime;
import com.ksc.schedule.entity.Trip;
import com.ksc.schedule.mapper.DozerMapper;
import com.ksc.schedule.service.RouteService;
import com.ksc.schedule.service.StopService;
import com.ksc.schedule.service.StopTimeService;
import com.ksc.schedule.service.TripService;
import com.ksc.schedule.utils.CoordinatesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
public class StationController {

    @Autowired
    private StopService stationService;

    @Autowired
    private TripService tripService;

    @Autowired
    private StopTimeService stopTimeService;

    @Autowired
    private StopService stopService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private DozerMapper mapper;

    @GetMapping(UrlMapping.STATIONS_NEAREST)
    public List<StopDto> findNearestStations(@PathParam("lat") String lat, String lon) {
        List<Stop> dbStations = stationService.findNearestStations(lat, lon);
        List<StopDto> nearestStations = mapper.mapList(dbStations, StopDto.class);
        nearestStations.forEach(o -> o.setDistance(CoordinatesConverter.distanceInMeters(o.getLat(), lat, o.getLon(), lon)));
        return nearestStations;
    }

    @GetMapping(UrlMapping.BUSES_OF_STATION)
    public List<BusesStationDto> findAllBusesOfStation(@PathVariable("id") String stationId) {
        List<StopTime> dbStopTime = stopTimeService.findByStation(stationId);
        List<BusesStationDto> busesStationDtos = new ArrayList<>();
        for (StopTime stopTime: dbStopTime) {
            String busNumber = stopTime.getTrip().getRoute().getShortName();
            BusesStationDto busesStationDto = new BusesStationDto();
            busesStationDto.setBusNumber(busNumber);
            busesStationDto.setDeparture(stopTime.getDeparture());
            busesStationDtos.add(busesStationDto);
        }
        busesStationDtos.sort(Comparator.comparing(BusesStationDto::getDeparture));
        return busesStationDtos;
    }

    @GetMapping(UrlMapping.STATIONS_BUS)
    public List<StopDto> findAllStationsOfBus(@PathVariable("number") String busNumber) {
        Route route = routeService.findRouteByBusNumber(busNumber);
        List<Trip> trips = tripService.findByRouteId(route.getId());
        List<StopTime> stopTimes = stopTimeService.findByTrips(trips);
        List<Stop> stops = stopTimes.stream().map(StopTime::getStop).collect(Collectors.toList());
        stops = stops.stream().filter(distinctByKey(Stop::getName))
                .filter(stop -> stop.getId().startsWith(route.getId().substring(0, 1)))
                .collect(Collectors.toList());
        return mapper.mapList(stops, StopDto.class);
    }

    @GetMapping(UrlMapping.STATIONS)
    public String updateStationsName() {
        List<Stop> dbStops = stopService.findAll();
        for(Stop stop: dbStops) {
            stop.setName(stop.getName().replaceAll("\"", ""));
            stopService.save(stop);
        }
        return "OK";
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
