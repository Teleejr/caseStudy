package org.perscholas;

import lombok.extern.java.Log;
import org.perscholas.dao.ICustomerRepo;
import org.perscholas.dao.IItemsRepo;
import org.perscholas.dao.ILocationRepo;
import org.perscholas.dao.ITabsRepo;
import org.perscholas.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Log
@Transactional
public class AppStartupRunner implements CommandLineRunner{

    ICustomerRepo customerRepo;
    IItemsRepo itemsRepo;
    ILocationRepo locationRepo;
    ITabsRepo tabsRepo;

    @Autowired
    public AppStartupRunner(ICustomerRepo customerRepo, IItemsRepo itemsRepo, ILocationRepo locationRepo, ITabsRepo tabsRepo) {
        this.customerRepo = customerRepo;
        this.itemsRepo = itemsRepo;
        this.locationRepo = locationRepo;
        this.tabsRepo = tabsRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("*************** START CUSTOMER SQL STATEMENTS ***************");
        customerRepo.save(new Customer("tel10", "tel10@gmail.com", "7314273", "$ycv4ptdGcp@F0C"));
        log.info("*************** START ITEMS SQL STATEMENTS ***************");
        log.info("*************** START LOCATION SQL STATEMENTS ***************");
        log.info("*************** START TAB SQL STATEMENTS ***************");




    }
}
