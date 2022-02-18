package com.bakerygb.bgbapp.models;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Slf4j
public class UserPrinciple implements UserDetails {

    private User user;

    public UserPrinciple(User user) {
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //return Collections.singleton(new SimpleGrantedAuthority("ADMIN"));
        return Collections.singleton(new GrantedAuthority() {
            @Override
            public String getAuthority() {

                if (user.getRole().equals(("ADMIN"))) {
                    log.warn("Admin role");
                    return "ADMIN";
                }
                log.warn("Customer role");
                return "CUSTOMER";

            }
        });
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
