package com.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryNameController
{
    @GetMapping(value = "/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllNames()
    {
        return new ResponseEntity<>(CountriesApplication.countryList.sortCountries(), HttpStatus.OK);
    }

    @GetMapping(value = "/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(
            @PathVariable
                    String letter)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.countryByFirstLetter(letter);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesBySize(
            @PathVariable
                    int number)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.countryList.countryByNameLength(number);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }
}
