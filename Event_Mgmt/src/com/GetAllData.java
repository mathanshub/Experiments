package com;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.Event;
import com.hib.GetSessionFactory;
import com.hib.Location;
import com.hib.Speaker;

public class GetAllData {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enetr Event ID:");

		int eid = sc.nextInt();

		Session session = GetSessionFactory.getSession();

		Transaction txn = session.beginTransaction();

		Event event = (Event) session.load(Event.class, eid);

		// session.close();

		System.out.println(event.getEvent_name());

		Location loc = event.getEvent_location();

		System.out.println(loc.getLoc_name());

		Set<Speaker> speakers = event.getEvent_speakers();

		Iterator<Speaker> it = speakers.iterator();

		while (it.hasNext()) {
			Speaker speaker = (Speaker) it.next();

			if (speaker.getSp_name().equals("naga")) {
				System.out.println("Orpahn");
				it.remove();
			}
		}

		// Delete-orpahn

		session.saveOrUpdate(event);

		txn.commit();

	}

}
