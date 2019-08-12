package com.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class CountryAgeController
{
    @GetMapping(value = "/age/{age}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByMedianAge(
            @PathVariable
                    int age)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.getCountriesByMedianAge(age);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByYoungestAge()
    {
        return new ResponseEntity<>(CountriesApplication.countryList.getCountryByLowestAge(), HttpStatus.OK);
    }

    @GetMapping(value = "/max",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByOldestAge()
    {
        return new ResponseEntity<>(CountriesApplication.countryList.getCountryByMaxAge(), HttpStatus.OK);
    }

    /* Stretch Goal */
    @GetMapping(value = "/median",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByMedianAge()
    {
        return new ResponseEntity<>(CountriesApplication.countryList.getCountryByMedianAge(), HttpStatus.OK);
    }
}
