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
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    private EmployeeTypeServiceImpl employeeTypeServiceImpl;

    @Autowired
    private JobTitleServiceImpl jobTitleServiceImpl;

    @Autowired
    private LocationServiceImpl locationServiceImpl;

    @Autowired
    private CountryServiceImpl countryServiceImpl;

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<Employee> employees = employeeServiceImpl.getEmployees();
        List<EmployeeType> employeeTypes = employeeTypeServiceImpl.getEmployeeTypes();
        List<JobTitle> jobTitles = jobTitleServiceImpl.getJobTitles();
        List<Location> locations = locationServiceImpl.getLocations();
        List<Country> countries = countryServiceImpl.getCountries();

        System.out.println(employees);
        System.out.println(employeeTypes);
        System.out.println(jobTitles);
        System.out.println(locations);
        System.out.println(countries);

        model.addAttribute("employees", employees);
        model.addAttribute("employeeTypes", employeeTypes);
        model.addAttribute("jobTitles", jobTitles);
        model.addAttribute("locations", locations);
        model.addAttribute("countries", countries);

        //ovaj model saljem ka HTML stranici
        return "Employee";
    }

    @PostMapping("/employees/addNew")
    public String addBew(Employee employee) {
        Employee saved = employeeServiceImpl.saveEmployee(employee);
        System.out.println(saved.getId());
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/findById/", params = {"id"}, method = RequestMethod.GET)
    @ResponseBody
    public Optional<Employee> findById(@RequestParam("id") Integer id) {
        Optional<Employee> employee = employeeServiceImpl.findById(id);
        System.out.println(employee);
        return employeeServiceImpl.findById(id);
    }

    @RequestMapping(value = "/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        Employee updated = employeeServiceImpl.saveEmployee(employee);
        System.out.println(updated.getId());
        return "redirect:/employees";
    }


    @RequestMapping(value = "/employees/deleteById/", params = {"id"}, method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(@RequestParam("id") Integer id) {
//        Optional<Location> location = locationServiceImpl.findById(id);
//        System.out.println(country);
        employeeServiceImpl.deleteById(id);
        return "redirect:/employees";
    }

}
