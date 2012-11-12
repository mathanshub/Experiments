package com;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.Event;
import com.hib.GetSessionFactory;

public class AddEvent {

	public static void main(String[] args) {

		Event event = new Event();
		event.setEvent_id(1);
		event.setEvent_name("Inagural");
//		event.setEvent_loc("bangalore");
		event.setEvent_dura(4);

		Transaction txn = null;
		Session session = null;
		try {
			session = GetSessionFactory.getSession();
			txn = session.beginTransaction();

			// Do

			// session.save(event);
			session.update(event);
			// session.saveOrUpdate(event);
			// session.delete(event);

			txn.commit();
			session.flush();
			System.out.println("Event Added");

		} catch (Exception e) {
			System.out.println(e);
			txn.rollback();

		}

	}

}
