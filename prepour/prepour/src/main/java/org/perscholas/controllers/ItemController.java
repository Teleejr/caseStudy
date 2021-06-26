package org.perscholas.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.models.Items;
import org.perscholas.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    OrdersService ordersService;

    //Add constructor
    public ItemController(AdminService adminService, EmployeeService employeeService, CustomerService customerService,
                          ItemService itemService, OrdersService ordersService) {
        this.adminService = adminService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.itemService = itemService;
        this.ordersService = ordersService;
    }

    @ModelAttribute("item")
    public Items initItem(){
        return new Items();
    }

    /*CREATE*/
    //Go to createItem page
    @GetMapping("/newitem")
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
            return "allItems";
        }

        else{ //If creation succeeds, go to the index page
            log.info("Item info: " + item.getName() + "  " + item.getType() + " " + item.getAbv() + " " + item.getPrice());
            Items newItem = itemService.saveItem(item);
            return "allItems";
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
    //Update Items page
    @GetMapping("/updateitem/{itemId}")
    public String updateItems(Model model, @PathVariable("itemId") Long id) {

        Items item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "updateItems";
    }

    //Show updated item info
    @PostMapping("/updateitem/{itemId}")
    public String saveUpdateItem(@ModelAttribute("item") @Valid Items item, BindingResult result, Model model, @PathVariable("itemId") Long id) {

        itemService.saveItem(item);
        return "allItems";
    }

    /*DELETE*/
    //Delete Item
    @GetMapping("/deleteitem/{itemId}")
    public String showDeleteAdmin(Model model, @PathVariable("itemId") Long id) {

        itemService.deleteById(id);
        model.addAttribute("allitems", itemService.findAllItems());
        return "allItems";
    }



}
