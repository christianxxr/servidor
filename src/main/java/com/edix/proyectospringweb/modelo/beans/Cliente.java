package com.edix.proyectospringweb.modelo.beans;

import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cif;

	private String domicilio;

	private double facturacionAnual;

	private String nombre;

	private int numeroEmpleados;

	public Cliente() {
	}

	public Cliente(String cif, String domicilio, double facturacionAnual, String nombre, int numeroEmpleados) {
		super();
		this.cif = cif;
		this.domicilio = domicilio;
		this.facturacionAnual = facturacionAnual;
		this.nombre = nombre;
		this.numeroEmpleados = numeroEmpleados;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public double getFacturacionAnual() {
		return this.facturacionAnual;
	}

	public void setFacturacionAnual(double facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroEmpleados() {
		return this.numeroEmpleados;
	}

	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		if (cif == null) {
			if (other.cif != null)
				return false;
		} else if (!cif.equals(other.cif))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", domicilio=" + domicilio + ", facturacionAnual=" + facturacionAnual
				+ ", nombre=" + nombre + ", numeroEmpleados=" + numeroEmpleados + "]";
	}

}
