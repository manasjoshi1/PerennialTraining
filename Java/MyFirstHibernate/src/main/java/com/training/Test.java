package com.training;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction txn = session.beginTransaction();
		Student s =new Student();
		s.setName("Manas");
		s.setCollege("kkw");
		s.setRollNo(1);
		session.save(s);
		txn.commit();
	}

}
