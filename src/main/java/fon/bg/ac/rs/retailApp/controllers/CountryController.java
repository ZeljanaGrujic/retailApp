package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.models.Country;
import fon.bg.ac.rs.retailApp.servicesImpl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryServiceImpl countryServiceImpl;

    @GetMapping("/countries")
    public String getCountries(Model model) {

        List<Country> countries = countryServiceImpl.getCountries();
        System.out.println(countries);
        model.addAttribute("countries", countries);
        //ovaj model saljem ka HTML stranici
        return "Country";
    }

    @PostMapping("/countries/addNew")
    public String addBew(Country country) {
        Country savedCountry = countryServiceImpl.saveCountry(country);
        System.out.println(savedCountry.getId());
        return "redirect:/countries";
    }

}
