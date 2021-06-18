package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.models.Customer;
import org.perscholas.services.CustomerService;
import org.perscholas.services.ItemService;
import org.perscholas.services.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Log
@Controller
public class HomeController {

    TabService tabService;
    CustomerService customerService;
    ItemService itemService;

    @Autowired
    public HomeController(TabService tabService) {
        this.tabService = tabService;
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }


    //Customer page
    @ModelAttribute("customer")
    public Customer initCustomer() {
        return new Customer();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/custlogin")
    public String customerRegistration() {
        return "customerLogin";
    }

    //Register page
    //Connect menu to db
}
