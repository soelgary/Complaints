package com.gsoeller.complaints.daos;

import java.util.List;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.gsoeller.complaints.mappers.ComplaintMapper;
import com.gsoeller.complaints.pojos.Complaint;


public interface ComplaintDao {

	@SqlQuery("select * from Complaint")
	@Mapper(ComplaintMapper.class)
	public List<Complaint> getComplaints();
	
	@SqlUpdate("insert into Complaint (text, time) values (:text, :time)")
	public void addComplaint(@Bind("text") String text, @Bind("time") DateTime time);
}
