package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.InvoiceSelling;
import fon.bg.ac.rs.retailApp.repositories.InvoiceSellingRepository;
import fon.bg.ac.rs.retailApp.services.InvoiceSellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceSellingServiceImpl implements InvoiceSellingService {

    @Autowired
    private InvoiceSellingRepository invoiceSellingRepository;

    @Override
    public List<InvoiceSelling> getInvoicesSelling() {
        return invoiceSellingRepository.findAll();
    }

    @Override
    public InvoiceSelling saveInvoiceSelling(InvoiceSelling invoiceSelling) {
        return invoiceSellingRepository.save(invoiceSelling);
    }

    @Override
    public Optional<InvoiceSelling> findById(int id) {
        return invoiceSellingRepository.findById(id);
    }
}
