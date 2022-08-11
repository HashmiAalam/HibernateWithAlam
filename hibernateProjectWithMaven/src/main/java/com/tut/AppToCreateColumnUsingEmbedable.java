package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
 * This class is using Embedable(Certificate) class to add column in its table
 */
public class AppToCreateColumnUsingEmbedable {
public static void main(String[] args) {
	Configuration configuration=new Configuration();
	configuration.configure("hibernate.cfg.xml");
	SessionFactory factory=configuration.buildSessionFactory();
	Student student=new Student();
	student.setId(201);
	student.setName("Wakeel");
	student.setCity("London");
	Certificate certificate=new Certificate();
	certificate.setCource("Android");
	certificate.setDuration("2 month");
	student.setCertificate(certificate);
	Student student1=new Student();
	student1.setId(202);
	student1.setName("Taosif");
	student1.setCity("France");
	Certificate certificate1=new Certificate();
	certificate1.setCource("php");
	certificate1.setDuration("6 month");
	student1.setCertificate(certificate1);
	Session session =factory.openSession();
	Transaction transaction=session.beginTransaction();
	session.save(student);
	session.save(student1);
	transaction.commit();
	session.close();
	factory.close();
	
	
}
}
