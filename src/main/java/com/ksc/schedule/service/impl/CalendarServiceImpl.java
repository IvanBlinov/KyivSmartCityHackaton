package com.ksc.schedule.service.impl;

import com.ksc.schedule.entity.Calendar;
import com.ksc.schedule.repository.CalendarRepository;
import com.ksc.schedule.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarRepository repository;

    @Override
    public Calendar save(Calendar calendar) {
        return repository.save(calendar);
    }
}
