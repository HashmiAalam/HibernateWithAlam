package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

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
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started" );
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
        //creating student
        Student student=new Student();
        student.setId(101);
        student.setName("Anil");
        student.setCity("Mumbai");
        //creating address
        Address address=new Address();
        address.setStreet("Street1");
        address.setCity("Mumbai");
        address.setOpen(true);
        address.setX(909.34);
        address.setAddedDate(new Date());
        //Reading image
        FileInputStream fileInputStream=new FileInputStream("src/main/java/pragiti.jpg");
        byte[] data=new byte[fileInputStream.available()]; //create the array of file size
        fileInputStream.read(data); //we have to read in data
        address.setImage(data);
        Session session=factory.openSession(); //openSessin() will be use one time, getSession(); will be use next time onwards
        Transaction transaction= session.beginTransaction();
        session.save(student);
        session.save(address);
        transaction.commit();
        session.close();
        System.out.println("Done...");
        
    }
}
