package com.tomprince.service;
  

import java.util.List;

import com.tomprince.domain.AdminUser;  

public interface AdminUserService {  
    public void addUser(AdminUser user);  
    public List<AdminUser> getUser();
	public AdminUser findByUserName(String username);  
  
}  
