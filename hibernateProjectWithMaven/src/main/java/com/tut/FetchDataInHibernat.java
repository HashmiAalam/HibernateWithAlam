package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDataInHibernat {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		/*
		 * get() method will hit db first time and after that it will give data from
		 * cache in next db call.
		 * in below case student object is from db and student1 is from cache
		 * if it not get data in db than it through NullPointerException
		 */
		Student student=(Student)session.get(Student.class, 101);
		Student student1=(Student)session.get(Student.class, 102);
		System.out.println(student); //if this line is not there than db call will still go in case of get() method
		System.out.println(student1);
		 
		/*
		 * whenever an object is created via load() method like student2 we get proxy object i.e only
		 * copy of object is coming i.e. no db call, when we use this object to get data like name of student
		 * than db call goes to db
		 * 
		 */
		Student student2=(Student)session.load(Student.class, 103);
		Student student3=(Student)session.load(Student.class, 104);
		System.out.println(student2); //if this line is not there than db call will not go in case of load() method
		System.out.println(student3);
		 
		session.close();
		factory.close();
	}
}
