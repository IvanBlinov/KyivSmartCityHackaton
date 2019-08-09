package com.ksc.schedule.bootstrap.workers;

import com.ksc.schedule.entity.*;
import com.ksc.schedule.service.*;
import com.ksc.schedule.utils.CSVReadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GlobalWorker implements BootStrapWorker {

    @Autowired
    private AgencyService agencyService;

    @Autowired
    private BlockService blockService;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private StopService stopService;

    @Autowired
    private StopTimeService stopTimeService;

    @Autowired
    private TripService tripService;

    @Autowired
    private ImportedService importedService;

    @Override
    public void doWork() {
        if (importedService.isImported()) return;
        System.out.println("START IMPORTING");
        importAgency();
        importBlocks();
        importCalendar();
        importRoutes();
        importStops();
        importTrips();
        importStopTimes();
        System.out.println("DONE!!");
        importedService.save(new Imported("something"));
    }

    private void importAgency() {
        List<String[]> agencyParts = CSVReadUtils.readCsv("agency.txt",",");
        int i = -1;
        for(String[] agencyLine : agencyParts) {
            i++;
            if (i == 0 || agencyLine.length < 5) continue;
            Agency agency = new Agency(agencyLine[0],agencyLine[1],agencyLine[2],agencyLine[3],agencyLine[4],agencyLine[5]);
            if (!agencyService.existsById(agencyLine[0])) {
                agencyService.save(agency);
            }
        }
    }

    private void importBlocks() {
        List<String[]> blockParts = CSVReadUtils.readCsv("blocks.txt",",");
        int i = -1;
        for(String[] blockLine : blockParts) {
            i++;
            if (i == 0 || blockLine.length < 4) continue;
            Block block = new Block(blockLine[0],blockLine[1],blockLine[2],Integer.parseInt(blockLine[3]),Integer.parseInt(blockLine[4]));
            if (!blockService.existsById(blockLine[0])) {
                blockService.save(block);
            }
        }
    }

    private void importCalendar() {
        List<String[]> calendarParts = CSVReadUtils.readCsv("calendar.txt",",");
        int i = -1;
        for(String[] calendarLine : calendarParts) {
            i++;
            if (i == 0 || calendarLine.length < 9) continue;
            Calendar calendar = new Calendar(calendarLine[0],calendarLine[1],calendarLine[2],calendarLine[3],calendarLine[4],calendarLine[5],calendarLine[6],calendarLine[7],calendarLine[8], calendarLine[9]);
            if (!calendarService.existsById(calendarLine[0])) {
                calendarService.save(calendar);
            }
        }
    }

    private void importRoutes() {
        List<String[]> routesParts = CSVReadUtils.readCsv("routes.txt",",");
        int i = -1;
        for(String[] calendarLine : routesParts) {
            i++;
            if (i == 0 || calendarLine.length < 6) continue;
            Agency agency = agencyService.findById(calendarLine[1]);
            Route route = new Route(calendarLine[0], agency, calendarLine[2],calendarLine[3],calendarLine[4],Integer.parseInt(calendarLine[5]));
            if (!routeService.existsById(calendarLine[0])) {
                routeService.save(route);
            }
        }
    }

    private void importStopTimes() {
        List<String[]> stopTimesParts = CSVReadUtils.readCsv("stop_times.txt",",");
        int i = -1;
        for(String[] stopTimeLine : stopTimesParts) {
            i++;
            if (i == 0 || stopTimeLine.length < 7) continue;
            Trip trip = tripService.findById(stopTimeLine[0]);
            Stop stop = stopService.findById(stopTimeLine[3]);
            StopTime stopTime = new StopTime(trip, stopTimeLine[1],stopTimeLine[2], stop, stopTimeLine[4],stopTimeLine[5],stopTimeLine[6]);
            if (!stopTimeService.existsByTrip(trip)) {
                stopTimeService.save(stopTime);
            }
        }
    }

    private void importStops() {
        List<String[]> stopsParts = CSVReadUtils.readCsv("stops.txt",",");
        int i = -1;
        for(String[] stopLine : stopsParts) {
            i++;
            if (i == 0 || stopLine.length < 5) continue;
            Stop stop = new Stop(stopLine[0], stopLine[1], stopLine[2],stopLine[3],stopLine[4]);
            if (!stopService.existsById(stopLine[0])) {
                stopService.save(stop);
            }
        }
    }

    private void importTrips() {
        List<String[]> tripsParts = CSVReadUtils.readCsv("trips.txt",",");
        int i = -1;
        for(String[] tripLine : tripsParts) {
            i++;
            if (i == 0 || tripLine.length < 5) continue;
            Route route = routeService.findById(tripLine[0]);
            Calendar calendar = calendarService.findById(tripLine[1]);
            Block block = blockService.findById(tripLine[4]);
            String tripId = tripLine[2];
            Trip trip = new Trip(tripId, route, calendar, tripLine[3], block);
            if (!tripService.existsById(tripId)) {
                tripService.save(trip);
            }
        }
    }
}
