package com.countries;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/names")
public class CountryNameController
{
    @GetMapping(value = "/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllNames()
    {
        return null;
    }

    @GetMapping(value="/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(@PathVariable String letter)
    {
        return null;
    }

    @GetMapping(value="/size/{number}",produces = {"application/json"})
    public ResponseEntity<?> getCountriesBySize(@PathVariable long number)
    {
        return null;
    }
}
