package com.doctorplus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Medicamento {
	
	@JsonProperty("nombre_medicamento")
	private String nombreMedicamento;

	public Medicamento() {
		this.nombreMedicamento = "";
	}

	@Override
	public String toString() {
		return "Medicamento [nombreMedicamento=" + nombreMedicamento + "]";
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String string) {
		this.nombreMedicamento = string;

	}
	
		
}