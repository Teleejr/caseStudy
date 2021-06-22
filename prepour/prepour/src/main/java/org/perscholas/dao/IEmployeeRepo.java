package org.perscholas.dao;

import org.perscholas.models.Customer;
import org.perscholas.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employees, Long> {

    Optional<Employees> findByusername(String username);
    Optional<Employees> getByemployeeId(Long id);
}
