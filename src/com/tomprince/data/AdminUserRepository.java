package com.tomprince.data;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tomprince.domain.AdminUser;

@Component
public class AdminUserRepository {
	@Autowired  
    private SessionFactory sessionfactory; 
//	private static SessionFactory sessionFactory = buildSessionFactory();
//
	public void addUser() {
		AdminUser user = new AdminUser("1", "1", "1", "AnotherRAWR", "user");
		
		Session session = sessionfactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
	}
//
//	public List<AdminUser> getUserList() {
//
//		// Open session
//		Session session = sessionFactory.openSession();
//		// Create Criteria
//		Criteria criteria = session.createCriteria(AdminUser.class);
//
//		// Get a list of contacts based on criteria
//		List<AdminUser> users = criteria.list();
//
//		// for (Iterator iterator = users.iterator(); iterator.hasNext();) {
//		// AdminUser employee = (AdminUser) iterator.next();
//		// System.out.print("First Name: " + employee.getUserName());
//		// }
//		// Closes session
//		session.close();
//		return users;
//	}
//
//	private static SessionFactory buildSessionFactory() {
//		StandardServiceRegistry registry = (new StandardServiceRegistryBuilder()).configure().build();
//		SessionFactory sessionFactory;
//		try {
//			sessionFactory = new Configuration().configure().
//					// addPackage("com.xyz") //add package if used.
//					addAnnotatedClass(AdminUser.class).buildSessionFactory(registry);
//		} catch (Throwable ex) {
//			System.err.println("Failed to create sessionFactory object." + ex);
//			throw new ExceptionInInitializerError(ex);
//		}
//		return sessionFactory;
//	}
}
