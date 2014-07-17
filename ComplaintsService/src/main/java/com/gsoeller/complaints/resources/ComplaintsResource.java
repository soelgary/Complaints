package com.gsoeller.complaints.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.inject.Inject;
import com.gsoeller.complaints.daos.ComplaintDao;
import com.gsoeller.complaints.pojos.Complaint;

@Path("/complaints")
@Produces(MediaType.APPLICATION_JSON)
public class ComplaintsResource {

	private ComplaintDao dao;
	
	@Inject
	public ComplaintsResource(ComplaintDao dao) {
		this.dao = dao;
	}
	
	@GET
	public List<Complaint> getComplaints() {
		return dao.getComplaints();
	}
	
	@POST
	public boolean addComplaint(Complaint complaint) {
		dao.addComplaint(complaint.getText(), complaint.getTime());
		return true;
	}
}
