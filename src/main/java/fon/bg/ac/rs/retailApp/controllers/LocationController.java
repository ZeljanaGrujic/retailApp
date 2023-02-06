package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.models.Country;
import fon.bg.ac.rs.retailApp.models.Location;
import fon.bg.ac.rs.retailApp.servicesImpl.CountryServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    private LocationServiceImpl locationServiceImpl;

    @Autowired
    private CountryServiceImpl countryServiceImpl;
    @GetMapping("/locations")
    public String getLocations(Model model) {

        List<Location> locations = locationServiceImpl.getLocations();
        List<Country> countries=countryServiceImpl.getCountries();
        System.out.println(locations);
        System.out.println(countries);
        model.addAttribute("locations", locations);
        model.addAttribute("countries", countries);
        //ovaj model saljem ka HTML stranici
        return "Location";
    }

    @PostMapping("/locations/addNew")
    public String addBew(Location location) {
        Location savedLocation = locationServiceImpl.saveLocation(location);
        System.out.println(savedLocation.getId());
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Optional<Location> findById(@RequestParam("id") Integer id) {
        Optional<Location> location = locationServiceImpl.findById(id);
        System.out.println(location);
        return locationServiceImpl.findById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        Location updatedLocation = locationServiceImpl.saveLocation(location);
        System.out.println(updatedLocation.getId());
        return "redirect:/locations";
    }


    @RequestMapping(value = "/locations/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {
//        Optional<Location> location = locationServiceImpl.findById(id);
//        System.out.println(country);
        locationServiceImpl.deleteById(id);
        return "redirect:/locations";
    }


}
