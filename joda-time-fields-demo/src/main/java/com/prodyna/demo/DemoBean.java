package com.prodyna.demo;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class DemoBean {
	private DateTime date;
	private Interval interval;
	
	public DemoBean() {
		date = new DateTime();
		interval = new Interval(0, 24*60*60*100);
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}
	
	
}
