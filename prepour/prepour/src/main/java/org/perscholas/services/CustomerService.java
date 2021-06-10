package org.perscholas.services;

import org.perscholas.dao.ICustomerRepo;
import org.perscholas.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class CustomerService {

    //Use the Customer repository
    ICustomerRepo customerRepo;

    //Create a constructor
    @Autowired
    public CustomerService(ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    //Find all customers
    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }

    //Get a customer by id
    public Customer getCustomerById(Long id) {
        return customerRepo.getById(id);
    }

    //Delete a customer by id
    public void deleteCustomerById(Long id) {
        customerRepo.deleteById(id);
    }

    //Save a customer
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

}
