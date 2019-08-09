package com.ksc.schedule.constants;

public interface UrlMapping {

    String API = "/api";

    String TRIP = API + "/trip";
    String TRIP_BY_ID = TRIP + "/{id}";
    String TRIP_BY_ROUTE_ID = TRIP + "/route/{id}";
}
