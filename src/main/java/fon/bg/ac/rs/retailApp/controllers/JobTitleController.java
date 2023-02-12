package fon.bg.ac.rs.retailApp.controllers;

import fon.bg.ac.rs.retailApp.dtos.JobTitleDto;
import fon.bg.ac.rs.retailApp.models.JobTitle;
import fon.bg.ac.rs.retailApp.servicesImpl.JobTitleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {


    @Autowired
    private JobTitleServiceImpl jobTitleServiceImpl;


    @GetMapping("/jobTitles")
    public String getJobTitles(Model model) {

        List<JobTitleDto> jobTitles = jobTitleServiceImpl.getJobTitles();
        System.out.println(jobTitles);
        model.addAttribute("jobTitles", jobTitles);
        //ovaj model saljem ka HTML stranici
        return "JobTitle";
    }

    @PostMapping("/jobTitles/addNew")
    public String addBew(JobTitleDto jobTitle) {
        JobTitleDto savedType = jobTitleServiceImpl.saveJobTitle(jobTitle);
        System.out.println(savedType.getId());
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/jobTitles/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public JobTitleDto findById(@RequestParam("id") Integer id) {
        JobTitleDto type = jobTitleServiceImpl.findById(id);
        System.out.println(type);
        return jobTitleServiceImpl.findById(id);
    }

    @RequestMapping(value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitleDto jobTitle) {
        JobTitleDto updatedType = jobTitleServiceImpl.saveJobTitle(jobTitle);
        System.out.println(updatedType.getId());
        return "redirect:/jobTitles";
    }


    @RequestMapping(value = "/jobTitles/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {
//        Optional<Location> location = locationServiceImpl.findById(id);
//        System.out.println(country);
        jobTitleServiceImpl.deleteById(id);
        return "redirect:/jobTitles";
    }


}
