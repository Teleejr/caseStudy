package org.perscholas.dao;

import org.perscholas.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrdersRepo extends JpaRepository<Orders, Long> {
    Optional<Orders> findByoId(Long id);
}
