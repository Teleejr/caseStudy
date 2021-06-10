package org.perscholas.services;

import org.perscholas.dao.ITabsRepo;
import org.perscholas.models.Tabs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class TabService {

    //Use Tab repository
    ITabsRepo tabsRepo;

    //Create a constructor
    @Autowired
    public TabService(ITabsRepo tabsRepo) {
        this.tabsRepo = tabsRepo;
    }

    //Find all Tabs
    public List<Tabs> findAllTabs() {
        return tabsRepo.findAll();
    }

    //Get Tabs by Id
    public Tabs getTabsById(Long id) {
        return tabsRepo.getById(id);
    }

    //Delete a Tab
    public void deleteTab(Long id) {
        tabsRepo.deleteById(id);
    }

    //Save Tab
    public Tabs saveTab(Tabs tab) {
        return tabsRepo.save(tab);
    }
}
