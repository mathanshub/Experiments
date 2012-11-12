package com.hib;

import java.io.Serializable;
import java.util.Set;

public class Event implements Serializable {

	private int event_id;
	private String event_name;
	private int event_dura;

	private Location event_location;

	private Set<Speaker> event_speakers;

	public Set<Speaker> getEvent_speakers() {
		return event_speakers;
	}

	public void setEvent_speakers(Set<Speaker> event_speakers) {
		this.event_speakers = event_speakers;
	}

	public Location getEvent_location() {
		return event_location;
	}

	public void setEvent_location(Location event_location) {
		this.event_location = event_location;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public int getEvent_dura() {
		return event_dura;
	}

	public void setEvent_dura(int event_dura) {
		this.event_dura = event_dura;
	}

}
