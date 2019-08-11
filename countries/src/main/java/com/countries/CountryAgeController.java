package com.countries;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/age")
public class CountryAgeController
{
    @GetMapping(value="/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByMedianAge(@PathVariable int age)
    {
        return null;
    }

    @GetMapping(value="/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryByYoungestAge()
    {
        return null;
    }

    @GetMapping(value="/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryByOldestAge()
    {
        return null;
    }

    /* Stretch Goal */
    @GetMapping(value="/median", produces = {"application/json"})
    public ResponseEntity<?> getCountryByMedianAge()
    {
        return null;
    }
}
