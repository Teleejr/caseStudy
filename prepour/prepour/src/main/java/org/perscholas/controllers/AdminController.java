package org.perscholas.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.models.Admin;
import org.perscholas.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    //Add necessary services
    AdminService adminService;
    EmployeeService employeeService;
    CustomerService customerService;
    ItemService itemService;
    TabService tabService;

    //Add constructor
    public AdminController(AdminService adminService, EmployeeService employeeService, CustomerService customerService,
                           ItemService itemService, TabService tabService) {
        this.adminService = adminService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.itemService = itemService;
        this.tabService = tabService;
    }

    @ModelAttribute("admin")
    public Admin initAdmin() {
        return new Admin();
    }

    /*CREATE*/
    //Go to create admin page
    @GetMapping("/newadmin")
    public String createCustomer() {
        return "createAdmin";
    }

    //Create new Admin
    @PostMapping("/newadmin")
    public String newAdmin(@ModelAttribute("admin") @Valid Admin admin, BindingResult result, Model model) {

        //If the creation fails, return to the createAdmin page
        if(result.hasErrors()) {
            log.info(String.valueOf(result.hasErrors()));
            log.info(result.getAllErrors().toString());
            return "createAdmin";
        }

        else{ //If creation succeeds, go to the index page
            System.out.println("Admin info: " + admin.getAdminId() + "  " + admin.getEmail());
            Admin newAd = adminService.saveAdmin(admin);
            return "index";
        }

    }

    /*READ*/
    //Show all employees
    @GetMapping("/allemployees")
    public String showAllEmployees(Model model, Model model2) {
        model2.addAttribute("alladmin", adminService.getAllAdmin());
        model.addAttribute("allemployees", employeeService.getAllEmployees());
        return "allEmployees";
    }

    //Show all admin
    @GetMapping("/alladmin")
    public String showAllAdmin(Model model) {
        model.addAttribute("alladmin", adminService.getAllAdmin());
        return "allAdmin";
    }

    //Show 1 admin
    @GetMapping("/adminprofile/{adminId}")
    public String showOneAdmin(@PathVariable("adminId") Long id, Model model) {
        model.addAttribute("admin", adminService.getByadminId(id));
        return "adminProfile";
    }

    /*UPDATE*/
    @GetMapping("/updateadmin/{adminId}")
    public String updateAdmin(Model model, @PathVariable("adminId") Long id) {

        Admin admin = adminService.getByadminId(id);
        model.addAttribute("admin", admin);

        return "updateAdmin";
    }

    //SHOW UPDATED ADMIN INFO
    @PostMapping("/updateadmin/{adminId}")
    public String saveUpdateAdmin(@ModelAttribute("admin") @Valid Admin admin, BindingResult result, Model model, @PathVariable("adminId") Long id) {

        adminService.saveAdmin(admin);
        return "adminProfile";
    }
    /*DELETE*/
    @GetMapping("/deleteadmin/{adminId}")
    public String showDeleteAdmin(Model model, @PathVariable("adminId") Long id) {

        adminService.deleteAdminById(id);
        model.addAttribute("alladmin", adminService.getAllAdmin());
        return "allAdmin";
    }

}
