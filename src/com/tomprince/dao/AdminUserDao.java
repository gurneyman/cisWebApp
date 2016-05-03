package com.tomprince.dao;

import java.util.List;

import com.tomprince.domain.AdminUser;  
  
  
public interface AdminUserDao {  
public void saveUser ( AdminUser user );  
public List<AdminUser> getUsers();
public AdminUser getUserByUserName(String username);  
  
}  
