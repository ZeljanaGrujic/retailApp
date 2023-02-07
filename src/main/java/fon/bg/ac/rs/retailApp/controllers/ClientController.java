package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.models.Client;
import fon.bg.ac.rs.retailApp.models.Country;
import fon.bg.ac.rs.retailApp.models.Location;
import fon.bg.ac.rs.retailApp.servicesImpl.ClientServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.CountryServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {


    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @Autowired
    private LocationServiceImpl locationServiceImpl;


    @GetMapping("/clients")
    public String getClients(Model model) {

        List<Location> locations = locationServiceImpl.getLocations();
        List<Client> clients=clientServiceImpl.getClients();
        System.out.println(locations);
        System.out.println(clients);
        model.addAttribute("locations", locations);
        model.addAttribute("clients", clients);
        //ovaj model saljem ka HTML stranici
        return "Client";
    }

    @PostMapping("/clients/addNew")
    public String addBew(Client client) {
        Client saved = clientServiceImpl.saveClient(client);
        System.out.println(saved.getId());
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Optional<Client> findById(@RequestParam("id") Integer id) {
        Optional<Client> client = clientServiceImpl.findById(id);
        System.out.println(client);
        return clientServiceImpl.findById(id);
    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        Client updated = clientServiceImpl.saveClient(client);
        System.out.println(updated.getId());
        return "redirect:/clients";
    }


    @RequestMapping(value = "/clients/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {
//        Optional<Location> location = locationServiceImpl.findById(id);
//        System.out.println(country);
        clientServiceImpl.deleteById(id);
        return "redirect:/clients";
    }


}
