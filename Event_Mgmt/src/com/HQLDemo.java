package com;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.hib.Event;
import com.hib.GetSessionFactory;
import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

public class HQLDemo {

	public static void main(String[] args) {

		Session session = GetSessionFactory.getSession();

		// 1. Primary Key

		// load
		// get

		// 2. HQL (Hibernate Query language

		// Query query=session.find();

		// Query query=session.iterate()

		// HQL

		/*
		 * 1. Positional params --> ?,?,?
		 * 
		 * 2. Named params (labels )
		 */

		// Query query =
		// session.createQuery(" from Event where event_name=:ename");
		Query query = session.getNamedQuery("Event.byName");
		query.setParameter("ename", "Hib Class", Hibernate.STRING);

		// query.setFirstResult(2);
		// query.setMaxResults(3);

		// List<Event> events = query.list();

		// for (Event ev : events) {
		// System.out.println(ev.getEvent_name());
		//
		// }

		List data = query.list();

		Iterator<Object[]> it = data.iterator();

		while (it.hasNext()) {
			
			Object[] type = (Object[]) it.next();
			System.out.println(type[0]);
			System.out.println(type[1]);

		}

	}
}
