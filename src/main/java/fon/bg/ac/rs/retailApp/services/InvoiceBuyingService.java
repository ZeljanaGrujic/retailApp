package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.InvoiceBuying;

import java.util.List;
import java.util.Optional;

public interface InvoiceBuyingService {
    List<InvoiceBuying> getInvoicesBuying();

    InvoiceBuying saveInvoiceBuying(InvoiceBuying invoiceBuying);

    Optional<InvoiceBuying> findById(int id);
}
