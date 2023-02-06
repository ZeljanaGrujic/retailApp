package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<Location> getLocations();

    Location saveLocation(Location location);

    Optional<Location> findById(int id);

    void deleteById(int id);
}
