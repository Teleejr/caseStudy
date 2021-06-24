package org.perscholas.security;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.dao.IAdminRepo;
import org.perscholas.dao.IAuthRepo;
import org.perscholas.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.perscholas.models.AuthGroup;
import java.util.List;

@Slf4j
@Service
public class AppUserDetailsService implements UserDetailsService {

    //Fields
    private final IAdminRepo adminRepo;
    private final IAuthRepo authGroup;

    //Constructor
    @Autowired
    public AppUserDetailsService(IAdminRepo adminRepo, IAuthRepo authGroup) {
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
        log.warn("authority group service " + authGroups);
        return new AppUserPrincipal(adminOptional.get(), authGroups);
    }

}
