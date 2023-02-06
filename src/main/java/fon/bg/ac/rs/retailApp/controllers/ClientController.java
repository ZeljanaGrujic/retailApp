package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.models.Country;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClientController {


    @GetMapping("/clients")
    public String getClients() {
        return "Client";
    }
}
