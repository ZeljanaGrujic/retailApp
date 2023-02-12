package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.dtos.CountryDto;
import fon.bg.ac.rs.retailApp.models.Country;
import fon.bg.ac.rs.retailApp.models.Location;
import fon.bg.ac.rs.retailApp.servicesImpl.CountryServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryServiceImpl countryServiceImpl;

    @Autowired
    private LocationServiceImpl locationServiceImpl;

    @GetMapping("/countries")
    public String getCountries(Model model) {

        List<CountryDto> countries = countryServiceImpl.getCountries();
        System.out.println(countries);
        model.addAttribute("countries", countries);
        //ovaj model saljem ka HTML stranici
//        fillLocations();
        return "Country";
    }

    @PostMapping("/countries/addNew")
    public String addBew(CountryDto country) {
        CountryDto savedCountry = countryServiceImpl.saveCountry(country);
        System.out.println(savedCountry.getId());
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public CountryDto findById(@RequestParam("id") Integer id) {
        CountryDto country = countryServiceImpl.findById(id);
        System.out.println(country);
        return countryServiceImpl.findById(id);
    }

    @RequestMapping(value = "/countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(CountryDto country) {
        CountryDto updatedCountry = countryServiceImpl.saveCountry(country);
        System.out.println(updatedCountry.getId());
        return "redirect:/countries";
    }


    @RequestMapping(value = "/countries/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {
//        Optional<Country> country = countryServiceImpl.findById(id);
//        System.out.println(country);
        countryServiceImpl.deleteById(id);
        return "redirect:/countries";
    }

//    private void fillLocations() {
//        List<Country> countries = countryServiceImpl.getCountries();
//        List<Country> filledCountries = new ArrayList<>();
//        for (Country c : countries) {
//            List<Location> locations = locationServiceImpl.findByCountryid(c.getId());
//            if (!locations.isEmpty()) {
//                c.setLocations(locations);
//            }
//            filledCountries.add(c);
//        }
//        for (Country c : filledCountries) {
//            if (!c.getLocations().isEmpty()) {
//                System.out.println(c.getName());
//                System.out.println(c.getCode());
//                System.out.println(c.getLocations());
//                System.out.println("**********");
//            }
//        }
//    }
}
