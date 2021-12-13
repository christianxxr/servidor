package com.edix.proyectospringweb.modelo.beans;

import java.io.Serializable;

public class ProyectoConProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int numeroOrden;

	private int cantidad;

	private double precioAsignado;

	private Producto producto;

	private Proyecto proyecto;

	public ProyectoConProducto() {
	}

	public ProyectoConProducto(int numeroOrden, int cantidad, double precioAsignado, Producto producto,
			Proyecto proyecto) {
		super();
		this.numeroOrden = numeroOrden;
		this.cantidad = cantidad;
		this.precioAsignado = precioAsignado;
		this.producto = producto;
		this.proyecto = proyecto;
	}

	public int getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioAsignado() {
		return this.precioAsignado;
	}

	public void setPrecioAsignado(double precioAsignado) {
		this.precioAsignado = precioAsignado;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
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
		result = prime * result + numeroOrden;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProyectoConProducto))
			return false;
		ProyectoConProducto other = (ProyectoConProducto) obj;
		if (numeroOrden != other.numeroOrden)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProyectoConProducto [numeroOrden=" + numeroOrden + ", cantidad=" + cantidad + ", precioAsignado="
				+ precioAsignado + ", producto=" + producto + ", proyecto=" + proyecto + "]";
	}

}
