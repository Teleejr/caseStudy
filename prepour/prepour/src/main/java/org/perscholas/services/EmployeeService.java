package org.perscholas.services;

import org.perscholas.dao.IEmployeeRepo;
import org.perscholas.models.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service @Transactional
public class EmployeeService {

    //Use the Employee repository
    IEmployeeRepo employeeRepo;

    //Create a constructor
    @Autowired
    public EmployeeService(IEmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    //Get all employees
    public List<Employees> getAllEmployees() {
        return employeeRepo.findAll();
    }

    //Get employee tab
//    public List<Items> getEmployeeTab(Long id) {
//        return employeeRepo.getemployeeTab(id);
//    }

    public Optional<Employees> findByusername(String username) {
        return employeeRepo.findByusername(username);
    }

    //Get a employee by id
    public Employees getByemployeeId(Long id) {
        return employeeRepo.getById(id);
    }

    //Delete a employee by id
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }

    //Save a employee
    public Employees saveEmployee(Employees employee) {
        return employeeRepo.save(employee);
    }

}
