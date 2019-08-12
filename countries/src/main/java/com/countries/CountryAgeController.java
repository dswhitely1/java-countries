package com.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

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
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.findCountries(c -> c.getAge() >= age);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByYoungestAge()
    {
        ArrayList<Country> tempCountryList = CountriesApplication.countryList.findCountries(c -> true);
        tempCountryList.sort(Comparator.comparingInt(Country::getAge));
        return new ResponseEntity<>(tempCountryList.get(0), HttpStatus.OK);
    }

    @GetMapping(value = "/max",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByOldestAge()
    {
        ArrayList<Country> tempCountryList = CountriesApplication.countryList.findCountries(c -> true);
        tempCountryList.sort((c1, c2) -> c2.getAge() - c1.getAge());
        return new ResponseEntity<>(tempCountryList.get(0), HttpStatus.OK);
    }

    /* Stretch Goal */
    @GetMapping(value = "/median",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByMedianAge()
    {
        ArrayList<Country> tempCountryList = CountriesApplication.countryList.findCountries(c -> true);
        tempCountryList.sort(Comparator.comparingInt(Country::getAge));
        return new ResponseEntity<>(tempCountryList.get(tempCountryList.toArray().length / 2), HttpStatus.OK);
    }
}
