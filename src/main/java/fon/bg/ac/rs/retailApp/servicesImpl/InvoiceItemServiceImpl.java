package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.dtos.CountryDto;
import fon.bg.ac.rs.retailApp.models.Country;
import fon.bg.ac.rs.retailApp.models.InvoiceItem;
import fon.bg.ac.rs.retailApp.models.InvoiceSelling;
import fon.bg.ac.rs.retailApp.repositories.InvoiceItemRepository;
import fon.bg.ac.rs.retailApp.repositories.InvoiceSellingRepository;
import fon.bg.ac.rs.retailApp.services.InvoiceItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<InvoiceItem> findByInvoiceSellingId(int id) {
        return invoiceItemRepository.findByInvoiceSellingId(id);
    }

    @Override
    public InvoiceItem findById(int id) {

        InvoiceItem find = invoiceItemRepository.findById(id).get();

        return find;
    }

    @Override
    public void deleteById(int id) {

        invoiceItemRepository.deleteById(id);
    }


//    @Override
//    public void deleteByTextileId(int invoicesellingid, int textileid) {
//        invoiceItemRepository.deleteByTextileId(invoicesellingid, textileid);
//    }


    //    @Override
//    public List<LocationDto> findByCountryid(int id) {
//        return locationRepository.findByCountryid(id);
//    }
}
