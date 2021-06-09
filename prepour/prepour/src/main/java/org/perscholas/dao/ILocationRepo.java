package org.perscholas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.stream.Location;

@Repository
public interface ILocationRepo extends JpaRepository<Location, Long> {
}
