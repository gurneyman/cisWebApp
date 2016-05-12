/*
Student Name:  Tom Prince  
Assignment # 3    
 Class: 4160
Features Included:
	Form Validation, Displaying all semesters with current dates, update semester dates

Advance Feature(if Any): Spring/Hibernate
 

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

*/
package com.tomprince.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tomprince.domain.Semester;
import com.tomprince.service.SemesterService;

@RestController
public class SemesterRestController {

	@Autowired
	private SemesterService semesterService;

	@RequestMapping(value = API.ROUTE + "semesters", method = RequestMethod.GET, produces = "application/json")
	public List<Semester> getSemesters() {
		return semesterService.getSemesters();
	}
	
	@RequestMapping(value = API.ROUTE + "semester/{id}", method = RequestMethod.GET, produces = "application/json")
	public Semester getSemester(@PathVariable(value="id") String id) {
		return semesterService.getSemester(id);
	}

}
