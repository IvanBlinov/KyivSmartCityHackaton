package com.ksc.schedule.service.impl;

import com.ksc.schedule.entity.Calendar;
import com.ksc.schedule.repository.CalendarRepository;
import com.ksc.schedule.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarRepository repository;

    @Override
    public Calendar save(Calendar calendar) {
        return repository.save(calendar);
    }

    @Override
    public void saveAll(List<Calendar> calendars) {
        repository.saveAll(calendars);
    }

    @Override
    public Calendar findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id) != null;
    }
}
