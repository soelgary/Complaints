package com.gsoeller.complaints.ComplaintsService;

import org.skife.jdbi.v2.DBI;

import com.gsoeller.complaints.daos.ComplaintDao;
import com.gsoeller.complaints.resources.ComplaintsResource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ComplaintsApplication extends Application<ComplaintsConfiguration>{

	public static void main(String[] args) throws Exception {
		new ComplaintsApplication().run(args);
	}
	
	@Override
	public void initialize(Bootstrap<ComplaintsConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
		
	}

	@Override
	public void run(ComplaintsConfiguration conf, Environment env)
			throws Exception {
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(env, conf.getDataSourceFactory(), "mysql");
		final ComplaintDao dao = jdbi.onDemand(ComplaintDao.class);
		env.jersey().register(new ComplaintsResource(dao));
		env.jersey().setUrlPattern("/api/*");
	}

}
