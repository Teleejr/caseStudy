package org.perscholas;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.dao.*;
import org.perscholas.models.*;
import org.perscholas.security.AppSecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@Transactional
public class AppStartupRunner implements CommandLineRunner{

    ICustomerRepo customerRepo;
    IItemsRepo itemsRepo;
    ILocationRepo locationRepo;
    ITabsRepo tabsRepo;
    IEmployeeRepo employeeRepo;
    IAdminRepo adminRepo;
    IAuthRepo authRepo;

    @Autowired
    public AppStartupRunner(ICustomerRepo customerRepo, IItemsRepo itemsRepo, ILocationRepo locationRepo,
                            ITabsRepo tabsRepo, IEmployeeRepo employeeRepo, IAdminRepo adminRepo, IAuthRepo authRepo) {
        this.customerRepo = customerRepo;
        this.itemsRepo = itemsRepo;
        this.locationRepo = locationRepo;
        this.tabsRepo = tabsRepo;
        this.employeeRepo = employeeRepo;
        this.adminRepo = adminRepo;
        this.authRepo = authRepo;
    }

    @Override
    public void run(String... args) throws Exception {


        log.info("*************** START CUSTOMER SQL STATEMENTS ***************");
        customerRepo.save(new Customer("T", "L", "tel10", "tel10@gmail.com", "7314273", "$ycv4ptdGcp@F0C"));
        customerRepo.save(new Customer("G", "Unit", "gunit", "gunit@gmail.com", "7314273", "$ycv4ptdGcp@F0C"));
        customerRepo.save(new Customer("Jahka", "J","jahka", "jahka@gmail.com", "7314273", "$ycv4ptdGcp@F0C"));
        customerRepo.save(new Customer("Slim", "P","slimp", "slimp@gmail.com", "7314273", "$ycv4ptdGcp@F0C"));

        log.info("*************** START EMPLOYEES SQL STATEMENTS ***************");
        employeeRepo.save(new Employees("Leaia", "Leia","Leia10", "leia@gmail.com", "7314273", "$ycv4ptdGcp@F0C"));

        log.info("*************** START ADMIN SQL STATEMENTS ***************");
        adminRepo.save(new Admin("Adam", "Ad", "Admin", "admin@gmail.com", "11111111", AppSecurityConfiguration.getPasswordEncoder().encode("Password1$")));
        adminRepo.save(new Admin("Aaron", "Karl", "Akay", "akay@gmail.com", "7314273", "$ycv4ptdGcp@F0C"));
        authRepo.save(new AuthGroup("Admin", "ROLE_ADMIN"));


        log.info("*************** START ITEMS SQL STATEMENTS ***************");
        itemsRepo.save(new Items("Apple Pie Milkshake Ale", "blonde ale", 5.5f, 5.00f, 56));
        itemsRepo.save(new Items("Coconut Cream Pie Ale", "blonde malt", 5.9f, 6.00f, 60));
        itemsRepo.save(new Items("Rice Barley Wine", "sake/wine", 13.3f, 8.00f, 77));
        itemsRepo.save(new Items("Barrel Aged Rye Pale Ale", "ale", 5.9f, 5.00f, 45));
        itemsRepo.save(new Items("Botanical Sour", "sour", 5.4f, 6.00f, 33));

        log.info("*************** START LOCATION SQL STATEMENTS ***************");
        locationRepo.save(new Locations("Mount Washington", "1234 Grandview Ave", "7775554"));
        locationRepo.save(new Locations("South Side", "1234 Carson Ave", "7775555"));
        locationRepo.save(new Locations("Lawrenceville", "1234 Butler St", "7775556"));

        log.info("*************** START TAB SQL STATEMENTS ***************");
        Customer c1 = new Customer("Lee", "Lee", "lee", "lee0@gmail.com", "7314273", "$ycv4ptdGcp@F0C");
        customerRepo.save(c1);
        Items item1 = new Items("Apple Pie Milkshake Ale", 5.00f);
        Items item2 = new Items("Coconut Cream Pie Ale", 6.00f);
        Items item3 = new Items("Rice Barley Wine", 8.00f);
        List<Items> tab;







    }
}
