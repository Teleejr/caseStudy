package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.models.Tabs;
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

    //Tab page
    @ModelAttribute("tab")
    public Tabs initTabs() {
        return new Tabs();
    }

    @PostMapping("/createtab")
    public String newTab(@ModelAttribute("tab") @Valid Tabs tab, BindingResult result, Model model) {

        System.out.println(result.hasErrors());
        if(result.hasErrors()) {
            log.warning("In if statement");
            log.warning("Error count: " + String.valueOf(result.getErrorCount()));
            return "index";
        }
        else {
            log.warning("NOT in if statement");
            log.info("Tab: " + tab);
            Tabs dbTabs = tabService.saveTab(tab);
            model.addAttribute("tab", tab);
            return "menu";
        }
    }
    //Register page
    //Connect menu to db
}
