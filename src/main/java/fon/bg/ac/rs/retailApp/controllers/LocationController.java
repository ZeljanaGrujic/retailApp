package fon.bg.ac.rs.retailApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {
    @GetMapping("/locations")
    public String getLocations() {
        return "Location";
    }
}
