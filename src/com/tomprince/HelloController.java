/*
Student Name:  Tom Prince  
Assignment # 4    
 Class: 4160
Features Included:
	Session, login, user validation,
	Form Validation, Displaying all semesters with current dates, update semester dates

Advance Feature(if Any): Spring/Hibernate, Spring Security and CSRF protection
 

References(if Any):
http://www.tutorialspoint.com/hibernate/hibernate_annotations.htm
https://sourcemaking.com/design_patterns
https://github.com/johnpapa/angular-styleguide/blob/master/a1/README.md#single-responsibility
https://docs.angularjs.org/api/ng/service/$q
https://www.luckyryan.com/2013/02/07/migrate-spring-mvc-servlet-xml-to-java-config/
http://www.journaldev.com/2552/spring-restful-web-service-example-with-json-jackson-and-client-program
http://stackoverflow.com/questions/25772426/hibernate-4-3-6-configuration-with-oracle-11g
http://fellowtuts.com/
http://stackoverflow.com/questions/1657557/spring-hibernate-unknown-entity
http://www.springframework.org/schema/aop/spring-aop-4.1.xsd
http://stackoverflow.com/questions/27560874/hibernate-saveorupdateall-not-doing-save-not-update
http://stackoverflow.com/questions/4374985/406-not-acceptable-in-spring-mvc-application-osgi-virgo-web-server-using-jack
http://tutorials.jenkov.com/java-json/jackson-installation.html
http://wiki.fasterxml.com/JacksonDownload
https://github.com/FasterXML?page=1
https://github.com/FasterXML/jackson-annotations
https://github.com/FasterXML/jackson-datatype-json-org
https://github.com/FasterXML/jackson-datatype-hibernate
http://mvnrepository.com/artifact/com.fasterxml.jackson.core
http://mvnrepository.com/artifact/com.fasterxml.jackson.core
http://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-smile/2.7.3
http://stackoverflow.com/questions/31275480/glassfish-4-rest-xml-working-json-error
http://stackoverflow.com/questions/15507064/return-literal-json-strings-in-spring-mvc-responsebody
http://stackoverflow.com/questions/5908466/jquery-spring-mvc-requestbody-and-json-making-it-work-together/5908632#5908632
http://stackoverflow.com/questions/4764405/how-to-use-relative-paths-without-including-the-context-root-name
http://stackoverflow.com/questions/22824190/how-to-use-format-date-as-yyyy-mm-dd-with-jstl
http://www.codejava.net/frameworks/spring/spring-mvc-form-handling-tutorial-and-example
http://www.tutorialspoint.com/spring/spring_mvc_form_handling_example.htm
http://stackoverflow.com/questions/9210733/use-formselect-tag-with-a-map
http://www.tutorialspoint.com/jsp/jstl_format_formatdate_tag.htm
http://www.mkyong.com/spring-mvc/spring-mvc-dropdown-box-example/
http://www.codejava.net/frameworks/spring/spring-mvc-form-validation-example-with-bean-validation-api
http://www.journaldev.com/2668/spring-mvc-form-validation-example-using-annotation-and-custom-validator-implementation
https://spring.io/guides/gs/validating-form-input/
http://www.concretepage.com/spring/spring-mvc/spring-mvc-form-validation-using-annotations
http://docs.oracle.com/javaee/6/tutorial/doc/gircz.html
http://stackoverflow.com/questions/24053139/spring-mvc-form-validation-date-field


	This file handles all of my routing. It should be broken up into controllers with unique responsibilities (login, admin, courseSearch)
*/

package com.tomprince;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tomprince.domain.AdminUser;
import com.tomprince.domain.Semester;
import com.tomprince.service.AdminUserService;
import com.tomprince.service.SemesterService;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.util.List;

// My main controller. All routes for the course schedule are here. I should break this out into an AdminController and BrowseController
@Controller
public class HelloController {
	// Handles interactions with the user data
	@Autowired
	private AdminUserService adminUserService;
	// Handles interaction with semester data
	@Autowired
	private SemesterService semesterService;

	// Test route that simply lists all users
	@RequestMapping("/hello")
	public String printHello(ModelMap model) {
		List<AdminUser> adminUsers = adminUserService.getUser();
		model.addAttribute("adminUsers", adminUsers);
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}
	@RequestMapping("/hello2")
	public String printHello2(ModelMap model) {
		List<AdminUser> adminUsers = adminUserService.getUser();
		model.addAttribute("adminUsers", adminUsers);
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "hello";
	}

	// Another test route that adds a new user to database.
	@RequestMapping("/test")
	public String printTest(ModelMap model) {
		AdminUser newUser = new AdminUser("1", "1", "1", "tommy", "passwerd");
		System.out.println("Trying to add: " + newUser.getUserName());
		adminUserService.addUser(newUser);
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "test/test";
	}

	// Fulfills the update.jsp requirement for HW4
	@RequestMapping({"/", "/login"})
	public String login(ModelMap model) {
		return "AdminSchReader/Login";
	}

	// Fulfills the update.jsp requirement for HW4
	@RequestMapping("/logout")
	public String logout(ModelMap model) {
		return "AdminSchReader/logout";
	}

	// Fulfills the update.jsp requirement for HW3
	@RequestMapping("/admin/update")
	public String adminSchedule(ModelMap model, Principal principal) {
		// Create object to hold semester info from form
		if (!model.containsAttribute("semesterForm")) {
	        model.addAttribute("semesterForm", new Semester());
	    }
		// Retrieve all semesters from db
		List<Semester> semesters = semesterService.getSemesters();
		// Add them to the model
		model.addAttribute("semesters", semesters);
		AdminUser user = adminUserService.findByUserName(principal.getName());
		System.out.println("USER DEPT: " + user.getDept());
		// Return route to the view
		return "AdminSchReader/update";
	}

	// Fulfills the display.jsp requirement for HW3
	// http://stackoverflow.com/questions/17792274/spring-mvc-error-400-the-request-sent-by-the-client-was-syntactically-incorrect
	@RequestMapping(value = "/admin/display", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("semesterForm") @Valid Semester semesterForm, BindingResult result,
			ModelMap model, RedirectAttributes attr, HttpSession session) {

		// Does the form have errors? Route user back to form with error
		// messages
		if (result.hasErrors()) {
			// Get the semesters again and add them to the model. Should be a
			// better way to do this
//			List<Semester> semesters = semesterService.getSemesters();
//			model.addAttribute("semesters", semesters);
//			return "AdminSchReader/update";
			attr.addFlashAttribute("org.springframework.validation.BindingResult.result", result);
		    attr.addFlashAttribute("semesterForm", semesterForm);
		    return "redirect:/admin/update";
		}
		// Get the record the user wishes to update and add it to the model
		Semester updatedSemester = semesterService.getSemester(semesterForm.getSemesterId());
		model.addAttribute("updatedSemester", updatedSemester);

		// Update semester and save it to the db
		updatedSemester.setStartDate(semesterForm.getStartDate());
		updatedSemester.setEndDate(semesterForm.getEndDate());
		semesterService.updateSemester(updatedSemester);

		// Send the user to the success page.
		return "AdminSchReader/display";
	}

}