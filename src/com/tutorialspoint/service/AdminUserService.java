package com.tutorialspoint.service;
  

import java.util.List;  
import com.tutorialspoint.domain.AdminUser;  

public interface AdminUserService {  
    public void addUser(AdminUser user);  
    public List<AdminUser> getUser();  
  
}  
