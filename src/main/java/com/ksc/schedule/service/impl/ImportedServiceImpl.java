package com.ksc.schedule.service.impl;

import com.ksc.schedule.entity.Imported;
import com.ksc.schedule.repository.ImportedRepository;
import com.ksc.schedule.service.ImportedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportedServiceImpl implements ImportedService {

    @Autowired
    private ImportedRepository repository;

    @Override
    public void save(Imported imported) {
        repository.save(imported);
    }

    @Override
    public boolean isImported() {
        return !repository.findAll().isEmpty();
    }
}
