package org.perscholas.security;

import org.perscholas.dao.IAdminRepo;
import org.perscholas.dao.IAuthGroupRepo;
import org.perscholas.models.Admin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.perscholas.models.AuthGroup;
import java.util.List;


@Service
public class AppUserDetailsService implements UserDetailsService {

    //Fields
    private final IAdminRepo adminRepo;
    private final IAuthGroupRepo authGroup;

    //Constructor
    public AppUserDetailsService(IAdminRepo adminRepo, IAuthGroupRepo authGroup) {
        this.adminRepo = adminRepo;
        this.authGroup = authGroup;
    }

    //Load user by username. If the user doesn't exist, throw exception saying user can't be found.
    //Return an AppUserPrincipal for the specific user being loaded.
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Admin> adminOptional = adminRepo.findByusername(s);

        if(adminOptional.isEmpty()) {
            throw new UsernameNotFoundException("Cannot find " + s);
        }

        List<AuthGroup> authGroups = authGroup.findByaUsername(s);
        return new AppUserPrincipal(adminOptional.get(), authGroups);
    }

}
