package com.ksc.schedule.service.impl;

import com.ksc.schedule.constants.Constants;
import com.ksc.schedule.entity.Stop;
import com.ksc.schedule.repository.StopRepository;
import com.ksc.schedule.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ksc.schedule.utils.CoordinatesConverter.distanceInMeters;

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

    @Override
    public List<Stop> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Stop> findNearestStations(String lat, String lon) {
        List<Stop> stations = repository.findAll();
        return stations.stream()
                .sorted((o1, o2) -> distanceInMeters(o1.getLat(), lat, o1.getLon(), lon).compareTo(distanceInMeters(o2.getLat(), lat, o2.getLon(), lon)))
                .limit(Constants.NEAREST_STATIONS_COUNT)
                .collect(Collectors.toList());
    }

}
