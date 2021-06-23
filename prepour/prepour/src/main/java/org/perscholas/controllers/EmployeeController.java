package org.perscholas.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.models.Admin;
import org.perscholas.models.Employees;
import org.perscholas.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("employee")
public class EmployeeController {

    //Add necessary services
    AdminService adminService;
    EmployeeService employeeService;
    CustomerService customerService;
    ItemService itemService;
    TabService tabService;

    //Add constructor
    public EmployeeController(AdminService adminService, EmployeeService employeeService, CustomerService customerService,
                              ItemService itemService, TabService tabService) {
        this.adminService = adminService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.itemService = itemService;
        this.tabService = tabService;
    }

    @ModelAttribute("employee")
    public Employees initEmployee() {
        return new Employees();
    }

    //Go to create employee page
    @GetMapping("/newemployee")
    public String createEmployee() {
        return "createEmployee";
    }

    //Create new Employee
    @PostMapping("/newemployee")
    public String newEmployee(@ModelAttribute("Employee") @Valid Employees employee, BindingResult result, Model model) {

        //If the creation fails, return to the createEmployee page
        if(result.hasErrors()) {
            log.info(String.valueOf(result.hasErrors()));
            log.info(result.getAllErrors().toString());
            return "createEmployee";
        }

        else{ //If creation succeeds, go to the index page
            System.out.println("Employee info: " + employee.getEmployeeId() + "  " + employee.getEmail());
            Employees newEmp = employeeService.saveEmployee(employee);
            return "index";
        }

    }

    //Show all customers
    @GetMapping("/allcustomers")
    public String showAllCustomers(Model model) {
        model.addAttribute("allcustomers", customerService.getAllCustomers());
        return "allCustomers";

    }

}
