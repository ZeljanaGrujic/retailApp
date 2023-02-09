package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.models.Client;
import fon.bg.ac.rs.retailApp.models.InvoiceSelling;
import fon.bg.ac.rs.retailApp.models.InvoiceStatus;
import fon.bg.ac.rs.retailApp.servicesImpl.ClientServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.InvoiceSellingServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.InvoiceStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceSellingController {

    @Autowired
    private InvoiceSellingServiceImpl invoiceSellingServiceImpl;

    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @Autowired
    private InvoiceStatusServiceImpl invoiceStatusServiceImpl;


    @GetMapping("/invoicesSelling")
    public String getInvoicesSelling(Model model) {

        List<InvoiceSelling> invoiceSellings = invoiceSellingServiceImpl.getInvoicesSelling();
        List<Client> clients=clientServiceImpl.getClients();
        List<InvoiceStatus>invoiceStatuses=invoiceStatusServiceImpl.getInvoiceStatuses();
        System.out.println(invoiceSellings);
        System.out.println(clients);
        System.out.println(invoiceStatuses);
        model.addAttribute("invoiceSellings", invoiceSellings);
        model.addAttribute("clients", clients);
        model.addAttribute("invoiceStatuses", invoiceStatuses);
        //ovaj model saljem ka HTML stranici
        return "InvoiceSelling";
    }

    @PostMapping("/invoicesSelling/addNew")
    public String addBew(InvoiceSelling invoiceSelling) {
        InvoiceSelling saved = invoiceSellingServiceImpl.saveInvoiceSelling(invoiceSelling);
        System.out.println(saved.getId());
        return "redirect:/invoicesSelling";
    }

    @RequestMapping(value = "/invoicesSelling/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Optional<InvoiceSelling> findById(@RequestParam("id") Integer id) {
        Optional<InvoiceSelling> invoice = invoiceSellingServiceImpl.findById(id);
        System.out.println(invoice);
        return invoiceSellingServiceImpl.findById(id);
    }

    @RequestMapping(value = "/invoicesSelling/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceSelling invoiceSelling) {
        InvoiceSelling updated = invoiceSellingServiceImpl.saveInvoiceSelling(invoiceSelling);
        System.out.println(updated.getId());
        return "redirect:/invoicesSelling";
    }


//    @RequestMapping(value = "/clients/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
//    public String deleteById(@RequestParam("id") Integer id) {
////        Optional<Location> location = locationServiceImpl.findById(id);
////        System.out.println(country);
//        clientServiceImpl.deleteById(id);
//        return "redirect:/clients";
//    }
}
