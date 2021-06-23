package org.perscholas.security;

import org.perscholas.models.Admin;
import org.perscholas.models.AuthGroup;
import org.perscholas.models.Customer;
import org.perscholas.models.Employees;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class AppUserPrincipal implements UserDetails {

    private Admin admin;
    private Employees employees;
    private Customer customer;
    private List<AuthGroup> authGroups;


    public AppUserPrincipal(Admin admin, Employees employees, Customer customer, List<AuthGroup> authGroups) {
        this.admin = admin;
        this.employees = employees;
        this.customer = customer;
        this.authGroups = authGroups;
    }

    public AppUserPrincipal(Admin admin, List<AuthGroup> authGroups) {
        this.admin = admin;
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(null == authGroups){
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        authGroups.forEach(authGroup -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getAAuthGroup()));
        });
        return grantedAuthorities;

        // return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return this.admin.getPassword();
    }

    @Override
    public String getUsername() {
        return this.admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
