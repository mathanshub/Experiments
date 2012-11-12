package com;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hib.Event;
import com.hib.GetSessionFactory;

public class CriteriaAPI {

	public static void main(String[] args) {

		Session session = GetSessionFactory.getSession();

		Criteria criteria = session.createCriteria(Event.class);

		// Criterion c1=Restrictions.like("event_name", "Java Class");
		// criteria.add(c1);

		// Order ord=Order.asc("event_name");
		// criteria.addOrder(ord);

		// Find By Example

		Event eventt = new Event();
		// eventt.setEvent_name("Hib Class");
		eventt.setEvent_dura(10);
		// eventt.setEvent_id(5);

		// Criterion c2 = Example.create(eventt);
		// criteria.add(c2);

		criteria.setProjection(Projections.max("event_dura"));
		//
		// List<Event> events = criteria.list();
		// Iterator<Event> eve = events.iterator();
		//
		// while (eve.hasNext()) {
		// Event event = (Event) eve.next();
		// System.out.println(event.getEvent_name());
		// System.out.println(event.getEvent_dura());
		//
		// }
		
		
		List data=criteria.list();
		
		System.out.println(data.get(0));
		

	}

}
