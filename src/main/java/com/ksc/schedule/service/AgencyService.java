package com.ksc.schedule.service;

import com.ksc.schedule.entity.Agency;

import java.util.List;

public interface AgencyService {

    Agency save(Agency agency);

    void saveAll(List<Agency> agencies);

    Agency findById(String id);

    boolean existsById(String id);
}
