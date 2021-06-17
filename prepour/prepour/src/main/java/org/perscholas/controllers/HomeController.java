package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.models.Customer;
import org.perscholas.models.Tabs;
import org.perscholas.services.CustomerService;
import org.perscholas.services.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Log
@Controller
@RequestMapping("app")
public class HomeController {

    TabService tabService;
    CustomerService customerService;

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

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    //Customer page
    @ModelAttribute("customer")
    public Tabs initTabs() {
        return new Tabs();
    }

    @GetMapping("/custlogin")
    public String customerRegistration() {
        return "customerLogin";
    }



    //Register page
    //Connect menu to db
}
