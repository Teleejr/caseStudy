package org.perscholas.dao;

import org.perscholas.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IItemsRepo extends JpaRepository<Items, Long> {
    Optional<Items> findByname(String itemName);
}
