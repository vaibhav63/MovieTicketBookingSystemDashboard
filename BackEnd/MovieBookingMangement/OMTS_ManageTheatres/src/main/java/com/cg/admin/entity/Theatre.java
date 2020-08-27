package com.cg.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Theatres")
public class Theatre {
	
	@Id
	private long theatreID;
	
	@Column(name = "theatre_name",nullable = false)
	private String theatreName;
	
	@Column(name = "theatre_city",nullable = false)
	private String theatreCity;
	
	@Column(name = "manager_name",nullable = false)

	private String managerName;
	
	@Column(name = "manager_contact",nullable = false,length = 10)
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
