package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.models.*;
import fon.bg.ac.rs.retailApp.servicesImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TextileController {

    @Autowired
    private TextileServiceImpl textileServiceImpl;
    @Autowired
    private TextileTypeServiceImpl textileTypeServiceImpl;

    @Autowired
    private TextileModelServiceImpl textileModelServiceImpl;

    @Autowired
    private TextileMakeServiceImpl textileMakeServiceImpl;

    @Autowired
    private TextileStatusServiceImpl textileStatusServiceImpl;

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    private SupplierServiceImpl supplierServiceImpl;
    @GetMapping("/textiles")
    public String getTextiles(Model model) {

        List<Textile> textiles = textileServiceImpl.getTextiles();
        List<TextileType> textileTypes=textileTypeServiceImpl.getTextileTypes();
        List<TextileMake> textileMakes = textileMakeServiceImpl.getTextileMakes();
        List<TextileModel> textileModels=textileModelServiceImpl.getTextileModels();
        List<TextileStatus> textileStatuses = textileStatusServiceImpl.getTextileStatuses();
        List<Employee> employees=employeeServiceImpl.getEmployees();
        List<Supplier> suppliers = supplierServiceImpl.getSuppliers();
        System.out.println(textiles);
        System.out.println(textileTypes);
        System.out.println(textileMakes);
        System.out.println(textileModels);
        System.out.println(textileStatuses);
        System.out.println(employees);
        System.out.println(suppliers);
        model.addAttribute("textiles", textiles);
        model.addAttribute("textileTypes", textileTypes);
        model.addAttribute("textileMakes", textileMakes);
        model.addAttribute("textileModels", textileModels);
        model.addAttribute("textileStatuses", textileStatuses);
        model.addAttribute("employees", employees);
        model.addAttribute("suppliers", suppliers);
        //ovaj model saljem ka HTML stranici
        return "Textile";
    }

    @PostMapping("/textiles/addNew")
    public String addBew(Textile textile) {
        Textile saved = textileServiceImpl.saveTextile(textile);
        System.out.println(saved.getId());
        return "redirect:/textiles";
    }

    @RequestMapping(value = "/textiles/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Optional<Textile> findById(@RequestParam("id") Integer id) {
        Optional<Textile> textile = textileServiceImpl.findById(id);
        System.out.println(textile);
        return textileServiceImpl.findById(id);
    }

    @RequestMapping(value = "/textiles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Textile textile) {
        Textile updated = textileServiceImpl.saveTextile(textile);
        System.out.println(updated.getId());
        return "redirect:/textiles";
    }


    @RequestMapping(value = "/textiles/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {
//        Optional<Location> location = locationServiceImpl.findById(id);
//        System.out.println(country);
        textileServiceImpl.deleteById(id);
        return "redirect:/textiles";
    }

}
