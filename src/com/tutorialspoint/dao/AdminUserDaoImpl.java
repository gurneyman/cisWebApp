package com.tutorialspoint.dao;

import java.util.List;  
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tutorialspoint.domain.AdminUser;  
  
  
@Repository("AdminUserDao")  
public class AdminUserDaoImpl implements AdminUserDao {  
  
  
    @Autowired  
    private SessionFactory sessionfactory;  
  
  
    @Override
    @Transactional
    public void saveUser(AdminUser user) {  
        sessionfactory.getCurrentSession().saveOrUpdate(user);  
    }  
  
  
    @Override
    @Transactional
    public List<AdminUser> getUsers() {  
  
        @SuppressWarnings("unchecked")  
        List<AdminUser> userlist = sessionfactory.getCurrentSession()  
                .createCriteria(AdminUser.class).list();  
        return userlist;  
  
    }  
  
}  