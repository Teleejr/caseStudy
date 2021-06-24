package org.perscholas.services;

import org.perscholas.dao.IItemsRepo;
import org.perscholas.models.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class ItemService {

    //Use the Items repository
    IItemsRepo itemsRepo;

    //Create a constructor
    @Autowired
    public ItemService(IItemsRepo itemsRepo) {
        this.itemsRepo = itemsRepo;
    }

    //Find all Items
    public List<Items> findAllItems() {
        return itemsRepo.findAll();
    }

    //Get an Item by id
    public Items getItemById(Long id) {
        return itemsRepo.getById(id);
    }

    //Delete an Item by id
    public void deleteById(Long id) {
        itemsRepo.deleteById(id);
    }

    //Save an Item
    public Items saveItem(Items item) {
        return itemsRepo.save(item);
    }


}//End class
