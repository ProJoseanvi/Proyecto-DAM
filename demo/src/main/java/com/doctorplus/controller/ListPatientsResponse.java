package com.doctorplus.controller;

import java.util.List;

import com.doctorplus.dto.Patient;

public class ListPatientsResponse {
	
	private List<Patient> patients;

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
