package org.perscholas.dao;

import org.perscholas.models.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ILocationRepo extends JpaRepository<Locations, Long> {
}
