package com.gsoeller.complaints.ComplaintsService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class ComplaintsConfiguration extends Configuration {

	@Valid
	@NotNull
	@JsonProperty
	private DataSourceFactory database = new DataSourceFactory();
	
	public DataSourceFactory getDataSourceFactory() {
		return database;
	}
}
