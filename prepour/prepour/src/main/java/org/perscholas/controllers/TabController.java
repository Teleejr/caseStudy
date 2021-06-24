package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.models.Items;
import org.perscholas.models.Tabs;
import org.perscholas.services.CustomerService;
import org.perscholas.services.ItemService;
import org.perscholas.services.LocationService;
import org.perscholas.services.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Log
@Controller
@RequestMapping("tab")
public class TabController {

    ItemService itemService;
    TabService tabService;
    CustomerService customerService;
    LocationService locationService;

    @Autowired
    public TabController(ItemService itemService) {
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
        model.addAttribute("tabitem", listItems);
        return "menu";
    }

}
