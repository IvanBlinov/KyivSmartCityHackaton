package com.ksc.schedule.repository;

import com.ksc.schedule.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {

    List<Route> findByIdStartsWith(String pattern);
    List<Route> findByShortName(String number);
}
