package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.models.Contact;
import fon.bg.ac.rs.retailApp.servicesImpl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {


    @Autowired
    private ContactServiceImpl contactServiceImpl;


    @GetMapping("/contacts")
    public String getContactss(Model model) {

        List<Contact> contacts=contactServiceImpl.getContacts();
        System.out.println(contacts);
        model.addAttribute("contacts", contacts);
        //ovaj model saljem ka HTML stranici
        return "MyContact";
    }

    @PostMapping("/contacts/addNew")
    public String addBew(Contact contact) {
        Contact saved = contactServiceImpl.saveContact(contact);
        System.out.println(saved.getId());
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Optional<Contact> findById(@RequestParam("id") Integer id) {
        Optional<Contact> contact = contactServiceImpl.findById(id);
        System.out.println(contact);
        return contactServiceImpl.findById(id);
    }

    @RequestMapping(value = "/contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact) {
        Contact updated = contactServiceImpl.saveContact(contact);
        System.out.println(updated.getId());
        return "redirect:/contacts";
    }


    @RequestMapping(value = "/contacts/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {
//        Optional<Location> location = locationServiceImpl.findById(id);
//        System.out.println(country);
        contactServiceImpl.deleteById(id);
        return "redirect:/contacts";
    }
}
