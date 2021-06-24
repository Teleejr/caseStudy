package org.perscholas.services;

import org.perscholas.dao.IAdminRepo;
import org.perscholas.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service @Transactional
public class AdminService {

    //Use the Admin repository
    IAdminRepo adminRepo;

    //Create a constructor
    @Autowired
    public AdminService(IAdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    //Get all admins
    public List<Admin> getAllAdmin() {
        return adminRepo.findAll();
    }

    //Get admin tab
//    public List<Items> getAdminTab(Long id) {
//        return adminRepo.getadminTab(id);
//    }

    public Optional<Admin> findByusername(String username) {
        return adminRepo.findByusername(username);
    }

    //Get a admin by id
    public Admin getByadminId(Long id) {
        return adminRepo.getById(id);
    }

    //Delete a admin by id
    public void deleteAdminById(Long id) {
        adminRepo.deleteById(id);
    }

    //Save/Update a admin
    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

}
