package fon.bg.ac.rs.retailApp.repositories;

import fon.bg.ac.rs.retailApp.models.OrderedTextile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedTextileRepository extends JpaRepository<OrderedTextile, Integer> {
}
