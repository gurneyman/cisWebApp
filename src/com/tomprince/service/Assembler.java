package com.tomprince.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("assembler")
public class Assembler {

    @Transactional
    public User buildUserFromEntity(com.tomprince.domain.AdminUser adminUser) {
        String username = adminUser.getUserName();
        String password = adminUser.getPassword();
        boolean enabled = true;

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(username, password, enabled, enabled, enabled, enabled, authorities);
    }
}
