package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.models.Customer;
import org.perscholas.models.Items;
import org.perscholas.services.CustomerService;
import org.perscholas.services.ItemService;
import org.perscholas.services.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Log
@Controller
public class HomeController {

    TabService tabService;
    CustomerService customerService;
    ItemService itemService;

    @Autowired
    public HomeController(TabService tabService, ItemService itemService, CustomerService customerService) {
        this.tabService = tabService;
        this.itemService = itemService;
        this.customerService = customerService;
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

    //Customer Page/Employee/Admin
    @GetMapping("/allcustomers")
    public String showAllCustomers(Model model) {
        model.addAttribute("allcustomers", customerService.getAllCustomers());
        return "allcustomers";

    }

//    //Menu Page
//    @ModelAttribute("items")
//    public Items initItems() {
//        return new Items();
//    }
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
