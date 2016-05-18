package com.tomprince.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.domain.CourseSection;
import com.tomprince.domain.Discipline;
import com.tomprince.domain.Semester;

@Repository("CourseSection")
public class CourseSectionDaoImpl implements CourseSectionDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Autowired
	private SemesterDao semesterDao;
	
	@Autowired
	private DisciplineDao disciplineDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CourseSection> getAll() {
		return sessionfactory.getCurrentSession().createCriteria(CourseSection.class).list();
	}

	@Override
	@Transactional
	public CourseSection getByIndex(String index) {
		return (CourseSection) sessionfactory.getCurrentSession().get(CourseSection.class, index);
	}
	
	@Override
	@Transactional
	public CourseSection getByCode(String code) {
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(CourseSection.class);
		criteria.add(Restrictions.eq("courseCode", code));
		return (CourseSection) criteria.list().get(0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional
	public Map<String, Map> getByDate(String semesterId, String discipline, String departmentId, String courseNumber, String days, String timeMod, String time, String instructorLastName ) {
		Semester semester = semesterDao.getSemester(semesterId);
		Date fromDate = semester.getStartDate();
		Date toDate = semester.getEndDate();
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(CourseSection.class);
		criteria.add(Restrictions.ge("startDate", fromDate)).add(Restrictions.le("endDate", toDate));
		
		// if DISC is set add restriction
		if(!discipline.equals("ALL")){
			System.out.println("DISCIPLINE: " + discipline);
			criteria.add(Restrictions.eq("discipline", discipline));
		}else if (!departmentId.equals("ALL")){
			System.out.println("department" + departmentId.getClass());
			List<Discipline> disciplines = disciplineDao.getById(departmentId);
			
			Disjunction disjunction = Restrictions.disjunction();
			for(int i = 0; i < disciplines.size(); i++){
				disjunction.add(Restrictions.eq("discipline", disciplines.get(i)));
			}
			criteria.add(disjunction);
		}
		// if courseNumber is set add restriction
		if(!courseNumber.equals("ALL")){
			criteria.add(Restrictions.ilike("courseNumber", "%" + courseNumber + "%"));
		}
		
		// if days add
		// NEED Time HASHMAP?
		// if Time
			// and if before add <
			// and if after add >
			// and if around add >= than one hour before and <= one hour after
		// if Instructor
		if(!instructorLastName.equals("ALL")){
			criteria.add(Restrictions.ilike("instructorLastName", "%" + instructorLastName + "%"));
		}
		
		
		List<CourseSection> sections = criteria.list();
		System.out.println(criteria.list());
		// What I'm returning.
		Map<String, Map> disciplineMap = new HashMap<String, Map>();
		Map<String, Map> courseMap = new HashMap<String, Map>();
		Map<String, List<CourseSection>> sectionMap = new HashMap<String, List<CourseSection>>();
		List<CourseSection> sectionList = new ArrayList<CourseSection>();
		// section in sections
		for (int i = 0; i < sections.size(); i++) {
			CourseSection current = sections.get(i);
			if(disciplineMap.containsKey(current.getDiscipline())){
				disciplineMap.get(current.getDiscipline());
				
			}else {
				courseMap = new HashMap<String, Map>();
			}
			if(courseMap.containsKey(current.getCourseNumber())){
				courseMap.get(current.getCourseNumber());
			}else {
				sectionMap = new HashMap<String, List<CourseSection>>();
			}
			if(sectionMap.containsKey(current.getSectionCode())){
				sectionList = sectionMap.get(current.getSectionCode());
			}else {
				sectionList = new ArrayList<CourseSection>();
			}
			// Everything is assigned correctly, now update each.
			sectionList.add(current);
			sectionMap.put(current.getSectionCode(), sectionList);
			courseMap.put(current.getCourseNumber(), sectionMap);
			disciplineMap.put(current.getDiscipline(), courseMap);
			
		}
		return disciplineMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CourseSection> getBySection(String discipline, String courseNumber, String courseSection) {
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(CourseSection.class);
		criteria.add(Restrictions.eq("discipline", discipline));
		criteria.add(Restrictions.eq("courseNumber", courseNumber));
		criteria.add(Restrictions.eq("sectionCode", courseSection));
		return criteria.list();
	}
}
