package com.ksc.schedule.service;

import com.ksc.schedule.entity.Imported;

public interface ImportedService {

    boolean isImported();
    void save(Imported imported);
}
