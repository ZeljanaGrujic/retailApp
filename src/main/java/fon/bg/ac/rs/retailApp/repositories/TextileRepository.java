package fon.bg.ac.rs.retailApp.repositories;

import fon.bg.ac.rs.retailApp.models.Textile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextileRepository extends JpaRepository<Textile, Integer> {

    List<Textile> findByPurpose(String purpose);
}
