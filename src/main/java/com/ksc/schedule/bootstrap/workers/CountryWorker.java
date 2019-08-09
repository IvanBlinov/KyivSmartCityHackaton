package com.ksc.schedule.bootstrap.workers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryWorker implements BootStrapWorker {

    @Autowired
    private CountryService countryService;

    @Override
    public void doWork() {
        addCountries();
    }
    
    private void addCountries() {
        List<Country> countries = countriesToAdd();
        for (Country country: countries) {
            if (!countryService.containsCountry(country)) {
                countryService.save(country);
            }
        }
    }

    private List<Country> countriesToAdd() {
        List<Country> countries = new ArrayList<>();
        return countries;
    }
}
