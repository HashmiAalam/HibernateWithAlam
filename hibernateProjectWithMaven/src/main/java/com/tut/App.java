package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project started" );
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
        Student student=new Student();
        student.setId(101);
        student.setName("Anil");
        student.setCity("Mumbai");
        Session session=factory.openSession(); //openSessin() will be use one time, getSession(); will be use next time onwards
        Transaction transaction= session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
        
    }
}
