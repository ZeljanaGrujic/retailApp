package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.Country;
import fon.bg.ac.rs.retailApp.repositories.CountryRepository;
import fon.bg.ac.rs.retailApp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired //ili na drugi nacin da inicijalizujem preko konstruktora
    private CountryRepository countryRepository;

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }


}
