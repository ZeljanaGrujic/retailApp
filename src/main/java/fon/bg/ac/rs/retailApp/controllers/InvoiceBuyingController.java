package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.dtos.InvoiceBuyingDto;
import fon.bg.ac.rs.retailApp.dtos.InvoiceStatusDto;
import fon.bg.ac.rs.retailApp.dtos.SupplierDto;
import fon.bg.ac.rs.retailApp.dtos.TextileDto;
import fon.bg.ac.rs.retailApp.models.InvoiceBuying;
import fon.bg.ac.rs.retailApp.models.InvoiceStatus;
import fon.bg.ac.rs.retailApp.models.Supplier;
import fon.bg.ac.rs.retailApp.servicesImpl.InvoiceBuyingServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.InvoiceStatusServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.SupplierServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.TextileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceBuyingController {

    @Autowired
    private SupplierServiceImpl supplierServiceImpl;

    @Autowired
    private InvoiceBuyingServiceImpl invoiceBuyingServiceImpl;

    @Autowired
    private InvoiceStatusServiceImpl invoiceStatusServiceImpl;

    @Autowired
    private TextileServiceImpl textileServiceImpl;


    @GetMapping("/invoicesBuying")
    public String getInvoicesBuying(Model model) {

        List<InvoiceBuyingDto> invoiceBuyings = invoiceBuyingServiceImpl.getInvoicesBuying();
        List<SupplierDto> suppliers=supplierServiceImpl.getSuppliers();
        List<InvoiceStatusDto>invoiceStatuses=invoiceStatusServiceImpl.getInvoiceStatuses();
        List<TextileDto>textiles=textileServiceImpl.getTextiles();
        System.out.println(invoiceBuyings);
        System.out.println(suppliers);
        System.out.println(invoiceStatuses);
        if(invoiceBuyings.isEmpty()){
            model.addAttribute("invoiceBuyings", null);
        }else{
            model.addAttribute("invoiceBuyings", invoiceBuyings);
        }

        model.addAttribute("suppliers", suppliers);
        model.addAttribute("invoiceStatuses", invoiceStatuses);
        model.addAttribute("textiles", textiles);
        //ovaj model saljem ka HTML stranici
        return "InvoiceBuying";
    }

    @PostMapping("/invoicesBuying/addNew")
    public String addBew(InvoiceBuyingDto invoiceBuying) {
        InvoiceBuyingDto saved = invoiceBuyingServiceImpl.saveInvoiceBuying(invoiceBuying);
        System.out.println(saved.getId());
        return "redirect:/invoicesBuying";
    }

    @RequestMapping(value = "/invoicesBuying/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public InvoiceBuyingDto findById(@RequestParam("id") Integer id) {
        InvoiceBuyingDto invoiceBuying = invoiceBuyingServiceImpl.findById(id);
        System.out.println(invoiceBuying);
        return invoiceBuyingServiceImpl.findById(id);
    }

    @RequestMapping(value = "/invoicesBuying/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceBuyingDto invoiceBuying) {
        InvoiceBuyingDto updated = invoiceBuyingServiceImpl.saveInvoiceBuying(invoiceBuying);
        System.out.println(updated.getId());
        return "redirect:/invoicesBuying";
    }


//    @RequestMapping(value = "/suppliers/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
//    public String deleteById(@RequestParam("id") Integer id) {
////        Optional<Location> location = locationServiceImpl.findById(id);
////        System.out.println(country);
//        supplierServiceImpl.deleteById(id);
//        return "redirect:/suppliers";
//    }

}
