package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSessionFactory {

	public static Session getSession() {

		Session session = null;

		Configuration config = new Configuration();
		config.configure();

		SessionFactory factory = config.buildSessionFactory();

		session = factory.openSession();

		return session;

	}

}
