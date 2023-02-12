package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.dtos.TextileModelDto;
import fon.bg.ac.rs.retailApp.models.TextileModel;
import fon.bg.ac.rs.retailApp.servicesImpl.TextileModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TextileModelController {

    @Autowired
    private TextileModelServiceImpl textileModelServiceImpl;

    @GetMapping("/textileModels")
    public String getTextileTypes(Model model) {

        List<TextileModelDto> textileModels = textileModelServiceImpl.getTextileModels();
        System.out.println(textileModels);
        model.addAttribute("textileModels", textileModels);
        //ovaj model saljem ka HTML stranici
        return "TextileModel";
    }

    @PostMapping("/textileModels/addNew")
    public String addBew(TextileModelDto textileModel) {
        TextileModelDto savedTextileModel = textileModelServiceImpl.saveTextileModel(textileModel);
        System.out.println(savedTextileModel.getId());
        return "redirect:/textileModels";
    }

    @RequestMapping(value = "/textileModels/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public TextileModelDto findById(@RequestParam("id") Integer id) {
        TextileModelDto textileModel = textileModelServiceImpl.findById(id);
        System.out.println(textileModel);
        return textileModelServiceImpl.findById(id);
    }

    @RequestMapping(value = "/textileModels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(TextileModelDto textileModel) {
        TextileModelDto updatedTextileModel = textileModelServiceImpl.saveTextileModel(textileModel);
        System.out.println(updatedTextileModel.getId());
        return "redirect:/textileModels";
    }


    @RequestMapping(value = "/textileModels/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {
//        Optional<Location> location = locationServiceImpl.findById(id);
//        System.out.println(country);
        textileModelServiceImpl.deleteById(id);
        return "redirect:/textileModels";
    }

}
