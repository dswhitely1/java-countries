package com.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController
{
    @GetMapping(value = "/size/{people}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByPopulationSize(
            @PathVariable
                    long people)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.countriesByPopulationSize(people);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByLeastPopulation()
    {
        return new ResponseEntity<>(CountriesApplication.countryList.getCountryByLowestPopulation(), HttpStatus.OK);
    }

    @GetMapping(value = "/max",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByMostPopulation()
    {
        return new ResponseEntity<>(CountriesApplication.countryList.getCountryByHighestPopulation(), HttpStatus.OK);
    }

    /* Stretch Goal */
    @GetMapping(value = "/median",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByMedian()
    {
        return new ResponseEntity<>(CountriesApplication.countryList.getCountryByMedianPopulation(), HttpStatus.OK);
    }
}
