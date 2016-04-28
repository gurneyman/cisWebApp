package com.tutorialspoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tutorialspoint.service.AdminUserService;
import com.tutorialspoint.service.SemesterService;
import com.tutorialspoint.domain.AdminUser;
import com.tutorialspoint.domain.Semester;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Controller
public class HelloController {
	@Autowired
	private AdminUserService adminUserService;

	@Autowired
	private SemesterService semesterService;

	// @RequestMapping(method = RequestMethod.GET)
	@RequestMapping("/hello")
	public String printHello(ModelMap model) {
		List<AdminUser> adminUsers = adminUserService.getUser();
		model.addAttribute("adminUsers", adminUsers);
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}

	@RequestMapping("/test")
	public String printTest(ModelMap model) {
		// List<AdminUser> adminUsers = adminUserRepository.getUserList();
		// model.addAttribute("adminUsers", adminUsers);
		AdminUser newUser = new AdminUser("1", "1", "1", "tommy", "passwerd");
		System.out.println("Trying to add: " + newUser.getUserName());
		adminUserService.addUser(newUser);
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "test/test";
	}

	@RequestMapping("/admin/update")
	public String adminSchedule(ModelMap model) {
		String error = (String) model.get((String) "error");
		System.out.println(error);
		Semester semesterForm = new Semester();
		model.addAttribute("semesterForm", semesterForm);
		List<Semester> semesters = semesterService.getSemesters();
		model.addAttribute("semesters", semesters);
		return "AdminSchReader/update";
	}

	// http://stackoverflow.com/questions/17792274/spring-mvc-error-400-the-request-sent-by-the-client-was-syntactically-incorrect
	@RequestMapping(value = "/admin/display", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("semesterForm") @Valid Semester semester, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()){
			List<ObjectError> errorList = result.getAllErrors();
			for(ObjectError error : errorList){
				System.out.println(error.getDefaultMessage());
			}
			System.out.println("Errors");
			model.addAttribute("error", "Error!");
			model.addAttribute("result", result);
			return adminSchedule(model);
		}
		System.out.println(semester);
		Semester updatedSemester = semesterService.getSemester(semester.getSemesterId());
		System.out.println(updatedSemester);

		model.addAttribute("updatedSemester", updatedSemester);
		
		// Update semester
		updatedSemester.setStartDate(semester.getStartDate());
		updatedSemester.setEndDate(semester.getEndDate());
		semesterService.updateSemester(updatedSemester);
		System.out.println(updatedSemester);

		return "AdminSchReader/display";
	}

}