package com.ksc.schedule.bootstrap;

import com.ksc.schedule.bootstrap.workers.BootStrapWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrap implements CommandLineRunner {

    @Autowired
    private List<BootStrapWorker> workers;

    @Override
    public void run(String... args) {
        for (BootStrapWorker worker : workers) {
            worker.doWork();
        }
    }
}
