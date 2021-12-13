package com.edix.proyectospringweb.modelo.beans;

import java.io.Serializable;

public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idFactura;

	private String descripcion;

	private Proyecto proyecto;

	public Factura() {
	}

	public Factura(String idFactura, String descripcion, Proyecto proyecto) {
		super();
		this.idFactura = idFactura;
		this.descripcion = descripcion;
		this.proyecto = proyecto;
	}

	public String getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFactura == null) ? 0 : idFactura.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Factura))
			return false;
		Factura other = (Factura) obj;
		if (idFactura == null) {
			if (other.idFactura != null)
				return false;
		} else if (!idFactura.equals(other.idFactura))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", descripcion=" + descripcion + ", proyecto=" + proyecto + "]";
	}

}