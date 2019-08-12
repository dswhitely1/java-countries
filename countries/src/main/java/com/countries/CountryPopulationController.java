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
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.findCountries(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByLeastPopulation()
    {
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.findCountries(c -> true);
        rtnCountries.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/max",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByMostPopulation()
    {
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.findCountries(c -> true);
        rtnCountries.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));
        return new ResponseEntity<>(rtnCountries.get(0), HttpStatus.OK);
    }

    /* Stretch Goal */
    @GetMapping(value = "/median",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByMedian()
    {
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.findCountries(c -> true);
        rtnCountries.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        return new ResponseEntity<>(rtnCountries.get(rtnCountries.toArray().length / 2), HttpStatus.OK);
    }
}
