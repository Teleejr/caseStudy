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

    @GetMapping("/register")
    public String register() {
        return "register";
    }

//    @GetMapping("/menu")
//    public String menu() {
//        return "menu";
//    }

    //Customer page
    @ModelAttribute("customer")
    public Customer initCustomer() {
        return new Customer();
    }

    @GetMapping("/custlogin")
    public String customerRegistration() {
        return "customerLogin";
    }

//    //Tab pages
//
//    //List all items in database
//    @GetMapping("/showmenu")
//    public String showMenu(@ModelAttribute("items") @Valid Items items, BindingResult result, Model model) {
//
//        List<Items> listItems = itemService.findAllItems();
//        model.addAttribute("tabitem", listItems);
//        return "menu";
//    }

    //Register page
    //Connect menu to db
}
