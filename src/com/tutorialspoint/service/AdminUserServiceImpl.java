package com.tutorialspoint.service;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Propagation;  
import org.springframework.transaction.annotation.Transactional;  
import com.tutorialspoint.dao.AdminUserDao;
import com.tutorialspoint.domain.AdminUser; 
  
  
@Service  
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)  
public class AdminUserServiceImpl implements AdminUserService {  
 
    @Autowired  
    AdminUserDao AdminUserDao;
      
  
  
    @Override  
    public List<AdminUser> getUser() {  
        return AdminUserDao.getUsers();  
  
    }


	@Override
	public void addUser(AdminUser user) {
		AdminUserDao.saveUser(user); 
		
	}  
}  
