package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.models.User;
import fon.bg.ac.rs.retailApp.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @GetMapping("/users")
    public String getUsers() {
        return "User";
    }

    @PostMapping(value="users/addNew")
    public RedirectView addNew(User user) {
        User saved= userServiceImpl.saveUser(user);
        System.out.println(saved);
        RedirectView  redirectView= new RedirectView("/login",true);
//        redir.addFlashAttribute("message",
//                "You successfully registered! You can now login");
        return redirectView;
    }
}
