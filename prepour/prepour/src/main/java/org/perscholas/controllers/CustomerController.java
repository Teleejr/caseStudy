package org.perscholas.controllers;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.models.Customer;
import org.perscholas.models.Items;
import org.perscholas.services.CustomerService;
import org.perscholas.services.ItemService;
import org.perscholas.services.TabService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("customer")

public class CustomerController {

    //Add Services
    CustomerService customerService;
    TabService tabService;
    ItemService itemService;

    //Add Constructor
    public CustomerController(CustomerService customerService, TabService tabService, ItemService itemService) {
        this.customerService = customerService;
        this.tabService = tabService;
        this.itemService = itemService;
    }

    @ModelAttribute("customer")
    public Customer initCustomer(){
        return new Customer();
    }


    //Go to create Customer page
    @GetMapping("/newcustomer")
    public String createCustomer() {
        return "createCustomer";
    }

    //Create new Customer
    @PostMapping("/newcustomer")
    public String newCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, Model model) {

        //If the creation fails, return to the createCustomer page
        if(result.hasErrors()) {
            log.info(String.valueOf(result.hasErrors()));
            log.info(result.getAllErrors().toString());
            return "createCustomer";
        }

        else{ //If creation succeeds, go to the index page
            System.out.println("Customer info: " + customer.getCustomerId() + "  " + customer.getEmail());
            Customer newCust = customerService.saveCustomer(customer);
            return "index";
        }

    }

    //Go to Customer tab page
    @GetMapping("/customertab")
    public String showTab() {
        return "customerTab";
    }

    //Show the customer tab
    @PostMapping("/customertab")
    public String customerTab(Model model, @RequestParam("customer") Long id) {
        Customer c = customerService.getCustomerById(id);
        List<Items> i = itemService.findAllItems();
        model.addAttribute("customer", i);
        return "customerTab";
    }




}
