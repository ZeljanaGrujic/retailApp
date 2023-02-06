package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.Location;
import fon.bg.ac.rs.retailApp.repositories.CountryRepository;
import fon.bg.ac.rs.retailApp.repositories.LocationRepository;
import fon.bg.ac.rs.retailApp.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired //ili na drugi nacin da inicijalizujem preko konstruktora
    private LocationRepository locationRepository;

    @Override
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Optional<Location> findById(int id) {
        return locationRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        locationRepository.deleteById(id);
    }
}
