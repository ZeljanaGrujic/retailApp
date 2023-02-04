package fon.bg.ac.rs.retailApp.repositories;

import fon.bg.ac.rs.retailApp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
