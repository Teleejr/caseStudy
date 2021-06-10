package org.perscholas.services;

import org.perscholas.dao.ILocationRepo;
import org.perscholas.models.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class LocationService {

    //Use Location repository
    ILocationRepo locationRepo;

    //Create a constructor
    @Autowired
    public LocationService(ILocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    //Find all Locations
    public List<Locations> findAllLocations() {
        return locationRepo.findAll();
    }

    //Get Location by Id
    public Locations getLocationById(Long id) {
        return locationRepo.getById(id);
    }

    //Delete Location by id
    public void deleteLocationById(Long id) {
        locationRepo.deleteById(id);
    }

    //Save Location
    public Locations saveLocation(Locations locations) {
        return locationRepo.save(locations);
    }
}
