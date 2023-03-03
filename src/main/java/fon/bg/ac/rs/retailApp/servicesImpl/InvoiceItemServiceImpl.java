package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.InvoiceItem;
import fon.bg.ac.rs.retailApp.models.InvoiceSelling;
import fon.bg.ac.rs.retailApp.repositories.InvoiceItemRepository;
import fon.bg.ac.rs.retailApp.repositories.InvoiceSellingRepository;
import fon.bg.ac.rs.retailApp.services.InvoiceItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Override
    public InvoiceItem saveInvoiceItem(InvoiceItem invoiceItem) {

        InvoiceItem saved = invoiceItemRepository.save(invoiceItem);
        invoiceItem.setId(saved.getId());

        return invoiceItem;
    }
}
