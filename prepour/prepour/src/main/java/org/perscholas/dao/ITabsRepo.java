package org.perscholas.dao;

import org.perscholas.models.Tabs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITabsRepo extends JpaRepository<Tabs, Long> {
    Optional<Tabs> findBytabId(Long id);
}
