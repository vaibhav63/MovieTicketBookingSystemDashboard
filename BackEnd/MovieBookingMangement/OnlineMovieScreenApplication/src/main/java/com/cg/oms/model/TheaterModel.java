package com.cg.oms.model;



public class TheaterModel {

private long theatreID;
	
	
	private String theatreName;
	
	
	private String theatreCity;
	


	private String managerName;
	
	
	private Long  managerContact;

	public long getTheatreID() {
		return theatreID;
	}

	public void setTheatreID(long theatreID) {
		this.theatreID = theatreID;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Long getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(Long managerContact) {
		this.managerContact = managerContact;
	}
	
}
