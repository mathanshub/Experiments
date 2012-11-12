package com;

import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.Event;
import com.hib.GetSessionFactory;
import com.hib.Location;
import com.hib.Speaker;

import org.hibernate.dialect.MySQLDialect;

public class AddEvent_Location {

	public static void main(String[] args) {

		try {

			Session session = GetSessionFactory.getSession();
			Transaction txn = session.beginTransaction();

			Event event = new Event();
			event.setEvent_id(5);
			event.setEvent_name("Hib Class");
			event.setEvent_dura(10);

			Location location = new Location();
			location.setLoc_id(3);
			location.setLoc_name("NIIT H.O");
			location.setLoc_addrs("Bangalore");
			
			
			Set<Speaker> speakers=new TreeSet<Speaker>();
			Speaker sp1=new Speaker();
			sp1.setSp_id(1);
			sp1.setSp_name("naga");
			
			Speaker sp2=new Speaker();
			sp2.setSp_id(2);
			sp2.setSp_name("Abc");
			
			speakers.add(sp1);
			speakers.add(sp2);
			

			event.setEvent_location(location);
			
			event.setEvent_speakers(speakers);

			//session.saveOrUpdate(location);
			session.saveOrUpdate(event);

			txn.commit();
			System.out.println("Done");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
