package fon.bg.ac.rs.retailApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TextileMakeController {
    @GetMapping("/textileMakes")
    public String getTextileMakes() {
        return "TextileMake";
    }
}
