package fon.bg.ac.rs.retailApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {
    @GetMapping("/suppliers")
    public String getCountries() {
        return "Supplier";
    }
}
