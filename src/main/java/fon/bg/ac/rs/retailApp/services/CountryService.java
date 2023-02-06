package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.Country;
import fon.bg.ac.rs.retailApp.repositories.CountryRepository;

import java.util.List;

public interface CountryService {

    public List<Country> getCountries();
    public Country saveCountry(Country country);
}
