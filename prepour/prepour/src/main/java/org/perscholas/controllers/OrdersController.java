package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.models.Items;
import org.perscholas.services.CustomerService;
import org.perscholas.services.ItemService;
import org.perscholas.services.LocationService;
import org.perscholas.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log
@Controller
@RequestMapping("orders")
public class OrdersController {

    ItemService itemService;
    OrdersService ordersService;
    CustomerService customerService;
    LocationService locationService;

    @Autowired
    public OrdersController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ModelAttribute("items")
    public Items initItems() {
        return new Items();
    }


    //LIST ALL ITEMS IN THE DATABASE
    @GetMapping("/showmenu")
    public String showMenu(@ModelAttribute("items") @Valid Items items, BindingResult result, Model model) {

        List<Items> listItems = itemService.findAllItems();
        model.addAttribute("orderitem", listItems);
        return "menu";
    }

}
