package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.models.Employee;
import fon.bg.ac.rs.retailApp.models.User;
import fon.bg.ac.rs.retailApp.security.models.Role;
import fon.bg.ac.rs.retailApp.servicesImpl.EmployeeServiceImpl;
import fon.bg.ac.rs.retailApp.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ProfileController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/myProfile", method = RequestMethod.GET)
    public String profile(Model model, Principal principal) {

        String username = principal.getName();
        Employee empProfile = new Employee();
                empProfile=employeeServiceImpl.findByUsername(username);

                if(empProfile == null){
                    User user = userServiceImpl.findByUsername(username);
//                    if (user.getRoles().isEmpty() || user.getRoles().equals(new Role(4, "USER","Ima pristup samo pocetnoj stranici i kategorijama odece (gornji delovi i donji delovi)")) ) {
//                        model.addAttribute("myProfile", user);
//                        return "profileUser";
//
//                        {
//                    kod usera admin mozda nije stigao da mu dodeli ulogu, pa je onda set uloga prazan, ili ako nije prazan i ima ulogu user onda vracas user a
//                    } slicnu proveru napisati ako je uloga VICE_ADMIN i roles nisu prazne, u svakom ostalom slucaju je admin
                    model.addAttribute("myProfile", user);
                    return "profileUser";
                }


            model.addAttribute("myProfile", empProfile);
            System.out.println(empProfile);

        //vraca username ulogovanog korisnika
        return "profile";
    }
}
