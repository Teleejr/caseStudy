package org.perscholas.dao;

import org.perscholas.models.Tabs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITabsRepo extends JpaRepository<Tabs, Long> {
}
