package com.countries;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/population")
public class CountryPopulationController
{
    @GetMapping(value = "/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByPopulationSize(@PathVariable long people)
    {
        return null;
    }

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryByLeastPopulation()
    {
        return null;
    }

    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryByMostPopulation()
    {
        return null;
    }

    /* Stretch Goal */
    @GetMapping(value="/median", produces = {"application/json"})
    public ResponseEntity<?> getCountryByMedian()
    {
        return null;
    }
}
