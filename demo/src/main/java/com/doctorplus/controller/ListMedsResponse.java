package com.doctorplus.controller;

import java.util.List;

import com.doctorplus.dto.Med;

public class ListMedsResponse {
	
	private List<Med> meds;

	public List<Med> getMeds() {
		return meds;
	}

	public void setMeds(List<Med> meds) {
		this.meds = meds;
	}

	

}
