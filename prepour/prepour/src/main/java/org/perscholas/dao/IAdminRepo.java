package org.perscholas.dao;

import org.perscholas.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAdminRepo extends JpaRepository<Admin, Long> {
    Optional<Admin> getByadminId(Long id);
    Optional<Admin> findByusername(String username);
    Optional<Admin> findByEmail(String email);
}
