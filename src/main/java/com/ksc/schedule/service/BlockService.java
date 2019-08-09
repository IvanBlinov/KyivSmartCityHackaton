package com.ksc.schedule.service;

import com.ksc.schedule.entity.Block;

import java.util.List;

public interface BlockService {

    Block save(Block block);

    void saveAll(List<Block>blocks);

    Block findById(String id);

    boolean existsById(String id);
}
