package com.cognizant.springlearn;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private final List<Country> countries = new ArrayList<>();

    public CountryService() {
        countries.add(new Country("IN", "India", "New Delhi"));
        countries.add(new Country("US", "United States", "Washington D.C."));
        countries.add(new Country("JP", "Japan", "Tokyo"));
    }

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getCountryByCode(String code) {
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}