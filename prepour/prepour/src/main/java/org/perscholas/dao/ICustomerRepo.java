package org.perscholas.dao;

import org.perscholas.models.Customer;
import org.perscholas.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByusername(String username);


    //List<Items> getcustomerTab(Long id);

}
