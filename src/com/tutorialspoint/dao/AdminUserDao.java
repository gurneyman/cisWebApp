package com.tutorialspoint.dao;

import java.util.List;  
import com.tutorialspoint.domain.AdminUser;  
  
  
public interface AdminUserDao {  
public void saveUser ( AdminUser user );  
public List<AdminUser> getUser();  
  
}  
