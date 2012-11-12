package com;

import org.hibernate.Session;

import com.hib.Event;
import com.hib.GetSessionFactory;

public class GetEvent {

	public static void main(String[] args) {

		try {

			Session session = GetSessionFactory.getSession();

			// Get Data With Primary KEy

//			Event event = (Event) session.load(Event.class, 10);
			Event event = (Event) session.get(Event.class, 10);
			
			System.out.println(event.getEvent_id());
			System.out.println(event.getEvent_name());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
