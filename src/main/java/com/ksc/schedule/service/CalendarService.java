package com.ksc.schedule.service;

import com.ksc.schedule.entity.Calendar;

import java.util.List;

public interface CalendarService {

    Calendar save(Calendar calendar);

    void saveAll(List<Calendar> calendars);

    Calendar findById(String id);

    boolean existsById(String id);
}
