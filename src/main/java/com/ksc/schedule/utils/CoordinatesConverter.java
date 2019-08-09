package com.ksc.schedule.utils;

public class CoordinatesConverter {

    private static final Integer LAT_TO_METERS = 111132;

    public static Integer distanceInMeters(String slat1, String slat2, String slon1, String slon2) {
        Double latDistance = latToMeters(slat1, slat2);
        Double lonDistance = lonToMeters(slat1, slat2, slon1, slon2);
        return (int)Math.sqrt(Math.pow(latDistance, 2) + Math.pow(lonDistance, 2));
    }

    private static Double latToMeters(String lat1, String lat2) {
        Double l1 = Double.parseDouble(lat1);
        Double l2 = Double.parseDouble(lat2);
        return Math.abs(l1 - l2) * LAT_TO_METERS;
    }

    private static Double lonToMeters(String slat1, String slat2, String slon1, String slon2) {
        Double lat1 = Double.parseDouble(slat1);
        Double lat2 = Double.parseDouble(slat2);
        double latMid = (lat2 + lat1) / 2;
        Double lon1 = Double.parseDouble(slon1);
        Double lon2 = Double.parseDouble(slon2);
        return Math.abs(lon1 - lon2) * LAT_TO_METERS * Math.cos(latMid);
    }
}
