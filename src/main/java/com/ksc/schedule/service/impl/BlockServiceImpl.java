package com.ksc.schedule.service.impl;

import com.ksc.schedule.entity.Block;
import com.ksc.schedule.repository.BlockRepository;
import com.ksc.schedule.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockRepository repository;

    @Override
    public Block save(Block block) {
        return repository.save(block);
    }

    @Override
    public void saveAll(List<Block> blocks) {
        repository.saveAll(blocks);
    }

    @Override
    public Block findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id) != null;
    }
}
