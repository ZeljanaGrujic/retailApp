package fon.bg.ac.rs.retailApp.repositories;

import fon.bg.ac.rs.retailApp.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Contact, Integer> {
}
