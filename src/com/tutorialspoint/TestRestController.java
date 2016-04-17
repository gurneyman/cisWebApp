package com.tutorialspoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.tutorialspoint.domain.AdminUser;
import com.tutorialspoint.service.AdminUserService;

@RestController	
public class TestRestController {
	@Autowired  
    private AdminUserService adminUserService; 
	
	@RequestMapping(value = "user", method = RequestMethod.GET, produces="application/json")
	public AdminUser getUser(){
		return new AdminUser("1", "1","1", "tommy", "passwerd");
	}
	
	@RequestMapping(value = "users", method = RequestMethod.GET, produces="application/json")
	public List<AdminUser> getUsers(){
		return adminUserService.getUser();
	}

}
