package com.VaccinationCenter.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name="vaccinationCenter")
@Entity
public class VaccinationCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String centerName;
	private String city;
	//check status 
	private String status;
		
	@OneToOne(mappedBy = "center")
	private Citizen citizen;

	@Override
	public String toString() {
	    return "VaccinationCenter [centerName=" + centerName + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	
}
