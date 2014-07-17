package com.gsoeller.complaints.pojos;

import org.joda.time.DateTime;

public class Complaint {

	private String text;
	private DateTime time;

	public Complaint() {}
	
	public Complaint(String text, DateTime time) {
		this.text = text;
		this.time = time;
	}
	
	public DateTime getTime() {
		return time;
	}

	public void setTime(DateTime time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
