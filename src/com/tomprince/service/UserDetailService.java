package com.tomprince.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tomprince.dao.AdminUserDao;
import com.tomprince.domain.AdminUser;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Autowired
    private Assembler assembler;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AdminUser adminUser = adminUserDao.getUserByUserName(username);

        if (adminUser == null)
            throw new UsernameNotFoundException("User not found");

        return assembler.buildUserFromEntity(adminUser);

    }
}
