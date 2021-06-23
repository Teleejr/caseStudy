package org.perscholas.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.models.Admin;
import org.perscholas.models.Items;
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
@RequestMapping("item")
public class ItemController {

    //Add necessary services
    AdminService adminService;
    EmployeeService employeeService;
    CustomerService customerService;
    ItemService itemService;
    TabService tabService;

    //Add constructor
    public ItemController(AdminService adminService, EmployeeService employeeService, CustomerService customerService,
                          ItemService itemService, TabService tabService) {
        this.adminService = adminService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.itemService = itemService;
        this.tabService = tabService;
    }

    @ModelAttribute("item")
    public Items initItem(){
        return new Items();
    }

    /*CREATE*/
    //Go to createItem page
    @GetMapping("/newadmin")
    public String createItem() {
        return "createItem";
    }

    //Create an Item
    @PostMapping("/newitem")
    public String newItem(@ModelAttribute("item") @Valid Items item, BindingResult result, Model model) {

        //If the creation fails, return to the createAdmin page
        if(result.hasErrors()) {
            log.info(String.valueOf(result.hasErrors()));
            log.info(result.getAllErrors().toString());
            return "createItem";
        }

        else{ //If creation succeeds, go to the index page
            log.info("Item info: " + item.getName() + "  " + item.getType() + " " + item.getAbv() + " " + item.getPrice());
            Items newItem = itemService.saveItem(item);
            return "index";
        }

    }

    /*READ*/
    //Show all Items
    @GetMapping("/allitems")
    public String showAllItems(Model model) {
        model.addAttribute("allitems", itemService.findAllItems());
        return "allItems";
    }
    /*UPDATE*/
    /*DELETE*/


}
