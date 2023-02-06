package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.Country;
import fon.bg.ac.rs.retailApp.repositories.CountryRepository;
import fon.bg.ac.rs.retailApp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Get Country By Id
    public Optional<Country> findById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }


}
