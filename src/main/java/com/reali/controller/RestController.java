package com.reali.controller;

import com.reali.dto.GeoJson;
import com.reali.service.Ilisting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {


    @Autowired
    Ilisting listingService;

    @GetMapping("/listing")
    public GeoJson getMissionRunning(@RequestParam Map<String, String> requestParams) {
        return listingService.filterListings(requestParams);
    }
}
