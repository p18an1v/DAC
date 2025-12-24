package mypack;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Main 
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
        Dept d1=new Dept();
	d1.setDname("Trg");
	d1.setLoc("Banglore");

	Dept d2=new Dept();
	d2.setDname("HR");
	d2.setLoc("Pune");
     
        session.persist(d1);
        session.persist(d2);
    
        tr.commit(); 
        System.out.println("After Commit");
        factory.close();
        System.out.println("done with records");  
	}
}
