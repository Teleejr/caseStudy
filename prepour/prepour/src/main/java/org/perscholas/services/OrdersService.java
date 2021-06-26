package org.perscholas.services;

import org.perscholas.dao.IOrdersRepo;
import org.perscholas.models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class OrdersService {

    //Use Tab repository
    IOrdersRepo tabsRepo;

    //Create a constructor
    @Autowired
    public OrdersService(IOrdersRepo tabsRepo) {
        this.tabsRepo = tabsRepo;
    }

    //Find all Tabs
    public List<Orders> findAllTabs() {
        return tabsRepo.findAll();
    }

    //Get Tabs by Id
    public Orders getTabsById(Long id) {
        return tabsRepo.getById(id);
    }

    //Delete a Tab
    public void deleteTab(Long id) {
        tabsRepo.deleteById(id);
    }

    //Save Tab
    public Orders saveTab(Orders tab) {
        return tabsRepo.save(tab);
    }
}
