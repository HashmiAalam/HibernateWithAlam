package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDataInHibernat {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Student student=(Student)session.get(Student.class, 101);
		System.out.println(student);
		session.close();
		factory.close();
	}
}
