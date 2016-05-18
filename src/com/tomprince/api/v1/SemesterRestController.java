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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tomprince.domain.Course;
import com.tomprince.domain.CourseComments;
import com.tomprince.domain.CourseSection;
import com.tomprince.domain.Department;
import com.tomprince.domain.Discipline;
import com.tomprince.domain.Instructor;
import com.tomprince.domain.Search;
import com.tomprince.domain.Semester;
import com.tomprince.domain.UpdateTime;
import com.tomprince.service.CourseCommentsService;
import com.tomprince.service.CourseSectionService;
import com.tomprince.service.CourseService;
import com.tomprince.service.DepartmentService;
import com.tomprince.service.DisciplineService;
import com.tomprince.service.InstructorService;
import com.tomprince.service.SemesterService;
import com.tomprince.service.UpdateTimeService;

@RestController
public class SemesterRestController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseSectionService courseSectionService;
	
	@Autowired
	private CourseCommentsService courseCommentsService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DisciplineService disciplineService;
	
	@Autowired
	private SemesterService semesterService;
	
	@Autowired
	private UpdateTimeService updateTimeService;
	
	@Autowired
	private InstructorService instructorService;
	
	@RequestMapping(value = API.ROUTE + "semesters", method = RequestMethod.GET, produces = "application/json")
	public List<Semester> getSemesters() {
		return semesterService.getSemesters();
	}
	
	@RequestMapping(value = API.ROUTE + "semester/{id}", method = RequestMethod.GET, produces = "application/json")
	public Semester getSemester(@PathVariable(value="id") String id) {
		return semesterService.getSemester(id);
	}
	
	@RequestMapping(value = API.ROUTE + "semester/{semester}/update-time", method = RequestMethod.GET, produces = "application/json")
	public UpdateTime getBySemester(@PathVariable(value="semester") String semester){
		return updateTimeService.getBySemester(semester);
	}
	
	@RequestMapping(value = API.ROUTE + "course/{discipline}/{number}", method = RequestMethod.GET, produces = "application/json")
	public Course getByNumber(@PathVariable(value="discipline") String discipline, @PathVariable(value="number") String number){
		return courseService.getByNumber(discipline, number);
	}
	
	@RequestMapping(value = API.ROUTE + "courses", method = RequestMethod.GET, produces = "application/json")
	public List<Course> getCourses(){
		return courseService.getAll();
	}
	
	@RequestMapping(value = API.ROUTE + "course-sections", method = RequestMethod.GET, produces = "application/json")
	public List<CourseSection> getCourseSections(){
		return courseSectionService.getAll();
	}
	
	@RequestMapping(value = API.ROUTE + "course-section/{courseIndex}", method = RequestMethod.GET, produces = "application/json")
	public CourseSection getSectionByCourseIndex(@PathVariable(value="courseIndex") String courseIndex){
		return courseSectionService.getByIndex(courseIndex);
	}
	@RequestMapping(value = API.ROUTE + "course-section/by-code/{courseCode}", method = RequestMethod.GET, produces = "application/json")
	public CourseSection getSectionByCourseCode(@PathVariable(value="courseCode") String courseCode){
		return courseSectionService.getByCode(courseCode);
	}
	
	@RequestMapping(value = API.ROUTE + "course-section/by-section/{discipline}/{courseNumber}/{courseSection}", method = RequestMethod.GET, produces = "application/json")
	public List<CourseSection> getSectionByCourseSection(@PathVariable(value="discipline") String discipline, @PathVariable(value="courseNumber") String courseNumber, @PathVariable(value="courseSection") String courseSection){
		return courseSectionService.getBySection(discipline, courseNumber, courseSection);
	}
	
	@RequestMapping(value = API.ROUTE + "course-comments", method = RequestMethod.GET, produces = "application/json")
	public List<CourseComments> getCourseComments(){
		return courseCommentsService.getAll();
	}
	
	@RequestMapping(value = API.ROUTE + "course-comments/{courseCode}", method = RequestMethod.GET, produces = "application/json")
	public CourseComments getCommentsByCourseCode(@PathVariable(value="courseCode") String courseCode){
		return courseCommentsService.getByCourseCode(courseCode);
	}
	
	@RequestMapping(value = API.ROUTE + "departments", method = RequestMethod.GET, produces = "application/json")
	public List<Department> getDepartments(){
		return departmentService.getAll();
	}
	
	@RequestMapping(value = API.ROUTE + "department/by-id/{id}", method = RequestMethod.GET, produces = "application/json")
	public Department getDepartmentById(@PathVariable(value="id") String id){
		return departmentService.getById(id);
	}
	
	@RequestMapping(value = API.ROUTE + "disciplines", method = RequestMethod.GET, produces = "application/json")
	public List<Discipline> getDisciplines(){
		return disciplineService.getAll();
	}
	
	@RequestMapping(value = API.ROUTE + "discipline/by-abbreviation/{abbreviation}", method = RequestMethod.GET, produces = "application/json")
	public Discipline getDisciplineByAbbreviation(@PathVariable(value="abbreviation") String abbreviation){
		return disciplineService.getByAbbreviation(abbreviation);
	}
	
	@RequestMapping(value = API.ROUTE + "department/by-name/{name}", method = RequestMethod.GET, produces = "application/json")
	public Department getDepartmentByName(@PathVariable(value="name") String name){
		return departmentService.getByName(name);
	}
	
	@RequestMapping(value = API.ROUTE + "instructor/{courseCode}", method = RequestMethod.GET, produces = "application/json")
	public Instructor getInstructorByCourseCode(@PathVariable(value="courseCode") String courseCode){
		return instructorService.getByCourseCode(courseCode);
	}
	
	@RequestMapping(value = API.ROUTE + "instructors", method = RequestMethod.GET, produces = "application/json")
	public List<Instructor> getInstructors(){
		return instructorService.getAll();
	}
	
	@RequestMapping(value = API.ROUTE + "searchTest", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Map> searchTest(){
		// TEST Values		
		return courseSectionService.getByDate("6", "ALL", "ALL", "ALL", "ALL", "ALL", "ALL", "ALL");
	}
	@RequestMapping(value = API.ROUTE + "search/{semesterId}/{discipline}/{departmentId}/{courseNumber}/{days}/{timeMod}/{time}/{instructorLastName}", method = RequestMethod.POST, produces = "application/json")
	public Map<String, Map> search(@PathVariable String semesterId, @PathVariable String discipline, @PathVariable String departmentId, @PathVariable String courseNumber, @PathVariable String days,
									@PathVariable String timeMod, @PathVariable String time, @PathVariable String instructorLastName){
		System.out.println(semesterId);
		// TEST Values	
		//return courseSectionService.getByDate(semesterId, discipline, "ALL", "ALL", "ALL", "ALL", "ALL", "ALL");
		return courseSectionService.getByDate(semesterId, discipline, departmentId, courseNumber, days, timeMod, time, instructorLastName);
	}

}
