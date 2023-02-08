package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.InvoiceSelling;

import java.util.List;
import java.util.Optional;

public interface InvoiceSellingService {
    List<InvoiceSelling> getInvoicesSelling();

    InvoiceSelling saveInvoiceSelling(InvoiceSelling invoiceSelling);

    Optional<InvoiceSelling> findById(int id);
}
