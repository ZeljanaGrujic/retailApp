package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<Supplier> getSuppliers();

    Supplier saveSupplier(Supplier supplier);

    Optional<Supplier> findById(int id);

    void deleteById(int id);
}
