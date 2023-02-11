package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.models.Employee;
import fon.bg.ac.rs.retailApp.models.User;
import fon.bg.ac.rs.retailApp.servicesImpl.EmployeeServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/myProfile", method = RequestMethod.GET)
    public String profile(Model model, Principal principal) {

        String username = principal.getName();
        Employee empProfile = employeeServiceImpl.findByUsername(username);
        User user = userServiceImpl.findByUsername(username);

        if (empProfile != null) {
            model.addAttribute("myProfile", empProfile);
            System.out.println(empProfile);
        } else {
            model.addAttribute("myProfile", user);
            System.out.println(user);
        }
        //vraca username ulogovanog korisnika
        return "profile";
    }
}
