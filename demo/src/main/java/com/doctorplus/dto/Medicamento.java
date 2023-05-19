package com.doctorplus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Medicamento {
	
	@JsonProperty("codigo_barras")
	private String codigoBarras;
	
	@JsonProperty("nombre_medicamento")
	private String nombreMedicamento;

	public Medicamento() {
		this.codigoBarras = "";
		this.nombreMedicamento = "";
	}

	@Override
	public String toString() {
		return "Medicamento [codigoBarras=" + codigoBarras + ", nombreMedicamento=" + nombreMedicamento + "]";
	}

	public String getCodigoBarras() {

		return codigoBarras;
	}

	public String getNombreMedicamento() {

		return nombreMedicamento;
	}

	public void setCodigoBarras(String string) {
		this.codigoBarras = string;

	}

	public void setNombreMedicamento(String string) {
		this.nombreMedicamento = string;

	}
	
		
}