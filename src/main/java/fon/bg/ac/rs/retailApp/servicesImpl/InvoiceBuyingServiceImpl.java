package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.InvoiceBuying;
import fon.bg.ac.rs.retailApp.repositories.InvoiceBuyingRepository;
import fon.bg.ac.rs.retailApp.services.InvoiceBuyingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceBuyingServiceImpl implements InvoiceBuyingService {

    @Autowired
    private InvoiceBuyingRepository invoiceBuyingRepository;

    @Override
    public List<InvoiceBuying> getInvoicesBuying() {
        return invoiceBuyingRepository.findAll();
    }

    @Override
    public InvoiceBuying saveInvoiceBuying(InvoiceBuying invoiceBuying) {
        return invoiceBuyingRepository.save(invoiceBuying);
    }

    @Override
    public Optional<InvoiceBuying> findById(int id) {
        return invoiceBuyingRepository.findById(id);
    }
}
