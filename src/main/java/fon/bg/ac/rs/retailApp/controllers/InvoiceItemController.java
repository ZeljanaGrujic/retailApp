package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.dtos.InvoiceSellingDto;
import fon.bg.ac.rs.retailApp.models.InvoiceItem;
import fon.bg.ac.rs.retailApp.servicesImpl.InvoiceItemServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.InvoiceSellingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InvoiceItemController {

    @Autowired
    private InvoiceItemServiceImpl invoiceItemServiceImpl;

    @PostMapping("/invoiceItems/addNew")
    public String addBew(InvoiceItem invoiceItem) {
        InvoiceItem saved = invoiceItemServiceImpl.saveInvoiceItem(invoiceItem);
        System.out.println("INVOICE SELLING ID ********************"+saved.getInvoicesellingid());
        return "redirect:/invoice/textile/Edit/?id="+saved.getInvoicesellingid();
    }
}
