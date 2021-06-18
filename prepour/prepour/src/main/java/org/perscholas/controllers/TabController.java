package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.models.Items;
import org.perscholas.services.ItemService;
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
@RequestMapping("tab")
public class TabController {

    ItemService itemService;

    @Autowired
    public TabController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ModelAttribute("items")
    public Items initItems() {
        return new Items();
    }


    //List all items in database
    @GetMapping("/showmenu")
    public String showMenu(@ModelAttribute("items") @Valid Items items, BindingResult result, Model model) {

        List<Items> listItems = itemService.findAllItems();
        model.addAttribute("tabitem", listItems);
        return "menu";
    }
}
