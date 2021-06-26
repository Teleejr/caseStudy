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
    IOrdersRepo orderRepo;

    //Create a constructor
    @Autowired
    public OrdersService(IOrdersRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    //Find all Tabs
    public List<Orders> findAllOrders() {
        return orderRepo.findAll();
    }

    //Get Tabs by Id
    public Orders getOrderssById(Long id) {
        return orderRepo.getById(id);
    }

    //Delete a Tab
    public void deleteOrders(Long id) {
        orderRepo.deleteById(id);
    }

    //Save Tab
    public Orders saveOrders(Orders orders) {
        return orderRepo.save(orders);
    }
}
