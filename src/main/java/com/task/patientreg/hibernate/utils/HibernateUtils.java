package com.task.patientreg.hibernate.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	
	static {
		Configuration conf= new Configuration();
		conf.configure();
	
	
	try {
		sessionFactory= new Configuration().configure().buildSessionFactory();
	}catch(HibernateException e) {
		System.out.println("Initial Session Factory Creation failed : "+e);
		throw new ExceptionInInitializerError(e);
	}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
