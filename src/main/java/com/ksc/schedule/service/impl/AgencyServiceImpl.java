package com.ksc.schedule.service.impl;

import com.ksc.schedule.entity.Agency;
import com.ksc.schedule.repository.AgencyRepository;
import com.ksc.schedule.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyRepository repository;

    @Override
    public Agency save(Agency agency) {
        return repository.save(agency);
    }

    @Override
    public void saveAll(List<Agency> agencies) {
        repository.saveAll(agencies);
    }

    @Override
    public Agency findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id) != null;
    }
}
