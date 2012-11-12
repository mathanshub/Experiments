package com;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.Event;
import com.hib.GetSessionFactory;

public class SessionDemo {

	public static void main(String[] args) {

		try {

			Session session = GetSessionFactory.getSession();

			Transaction txn = session.beginTransaction();

			Event event = (Event) session.load(Event.class, 1);

			event.setEvent_name("Farewell");

			session.saveOrUpdate(event);

			// After

			
			
			Event event2 = (Event) session.load(Event.class, 1);
			
			if(session.contains(event2)){
				session.evict(event2);
			}
			
			event2.setEvent_dura(5);
			session.saveOrUpdate(event2);

			txn.commit();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
