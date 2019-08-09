package com.ksc.schedule.constants;

public interface UrlMapping {

    String API = "/api";

    String TRIP = API + "/trip";
    String TRIP_BY_ID = TRIP + "/{id}";
    String TRIP_BY_ROUTE_ID = TRIP + "/route/{id}";

    String ROUTES = API + "/routes";
    String ROUTES_BUS = ROUTES + "/bus";
    String ROUTES_TROLLEYBUS = ROUTES + "/trolleybus";
    String ROUTES_TRAMWAY = ROUTES + "/tramway";

    String BUSES = API + "/buses";
    String BUSES_OF_STATION = BUSES + "/station/{id}";

    String STATIONS = API + "/stations";
    String STATIONS_NEAREST = STATIONS + "/nearest";
    String STATIONS_BUS = STATIONS + "/bus/{number}";
}
