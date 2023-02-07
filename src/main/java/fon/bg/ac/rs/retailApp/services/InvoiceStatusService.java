package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.InvoiceStatus;

import java.util.List;
import java.util.Optional;

public interface InvoiceStatusService {
    List<InvoiceStatus> getInvoiceStatuses();

    InvoiceStatus saveInvoiceStatus(InvoiceStatus invoiceStatus);

    Optional<InvoiceStatus> findById(int id);
}
