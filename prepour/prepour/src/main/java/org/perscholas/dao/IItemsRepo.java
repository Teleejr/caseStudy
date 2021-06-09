package org.perscholas.dao;

import org.perscholas.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemsRepo extends JpaRepository<Items, Long> {
}
