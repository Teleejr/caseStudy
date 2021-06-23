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
    @GetMapping("/customertab/1")
    public String showTab(Model model1) {

        Items tab = new Items();
        model1.addAttribute("items", tab);
        return "customerTab";
    }

    //Show the customer tab
    @PostMapping("/customertab/{customerId}")
    public String customerTab(@ModelAttribute("items") @Valid Items item, BindingResult result,
                              Model model, @PathVariable("customerId") Long id) {

        Customer c = customerService.getCustomerById(id);
        List<Items> i = itemService.findAllItems();
        model.addAttribute("customerTab", i);
        itemService.saveItem(item);

        return "customerTab";
    }

 /*   //Code for sending javascript object to database
    @RequestMapping(value = "/showmenu", method = RequestMethod.POST)

    public @ResponseBody String addItem(@RequestBody Items items)throws ParseException, IOException {
        log.info("Adding new item");

        // perform add operation
        try {
            log.info("Successfully added item");
            return "customerTab";
        }
        //item wasn't added
        catch (Exception ex) {
            ex.printStackTrace();
            log.info("Add item failed");
            return "index";

        }
    }//end addItem*/


}
