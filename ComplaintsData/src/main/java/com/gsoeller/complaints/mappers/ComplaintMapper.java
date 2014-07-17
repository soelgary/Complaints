package com.gsoeller.complaints.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.gsoeller.complaints.pojos.Complaint;

public class ComplaintMapper implements ResultSetMapper<Complaint>{

	public Complaint map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		String time = r.getString("time");
		return new Complaint(r.getString("text"), formatter.parseDateTime(r.getString("time").substring(0, time.length() - 2)));
	}
}
