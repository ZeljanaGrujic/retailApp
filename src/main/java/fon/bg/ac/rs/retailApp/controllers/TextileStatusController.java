package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.models.TextileStatus;
import fon.bg.ac.rs.retailApp.servicesImpl.TextileStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TextileStatusController {

    @Autowired
    private TextileStatusServiceImpl textileStatusServiceImpl;

    @GetMapping("/textileStatuses")
    public String getTextileStatus(Model model) {

        List<TextileStatus> textileStatuses = textileStatusServiceImpl.getTextileStatuses();
        System.out.println(textileStatuses);
        model.addAttribute("textileStatuses", textileStatuses);
        //ovaj model saljem ka HTML stranici
        return "TextileStatus";
    }

    @PostMapping("/textileStatuses/addNew")
    public String addBew(TextileStatus textileStatus) {
        TextileStatus savedTextileStatus = textileStatusServiceImpl.saveTextileStatus(textileStatus);
        System.out.println(textileStatus.getId());
        return "redirect:/textileStatuses";
    }

    @RequestMapping(value = "/textileStatuses/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Optional<TextileStatus> findById(@RequestParam("id") Integer id) {
        Optional<TextileStatus> textileStatus = textileStatusServiceImpl.findById(id);
        System.out.println(textileStatus);
        return textileStatusServiceImpl.findById(id);
    }
}
