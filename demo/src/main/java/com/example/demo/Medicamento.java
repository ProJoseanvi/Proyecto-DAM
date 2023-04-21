package com.example.demo;

public class Medicamento {
	
	private String codigoBarras;
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