package fon.bg.ac.rs.retailApp.repositories;

import fon.bg.ac.rs.retailApp.models.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer> {
}
