package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.models.Customer;
import org.perscholas.services.CustomerService;
import org.perscholas.services.ItemService;
import org.perscholas.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Log
@Controller
public class HomeController {

    OrdersService ordersService;
    CustomerService customerService;
    ItemService itemService;

    @Autowired
    public HomeController(OrdersService ordersService, ItemService itemService, CustomerService customerService) {
        this.ordersService = ordersService;
        this.itemService = itemService;
        this.customerService = customerService;
    }

    //ALL ACCESS MAPPING
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/403")
    public String forbidden() {
        return "403";
    }


    //CUSTOMER PAGE
    @ModelAttribute("customer")
    public Customer initCustomer() {
        return new Customer();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/custlogin")
    public String customerLogin() {
        return "customerLogin";
    }

    //Register page
    //Connect menu to db
}
