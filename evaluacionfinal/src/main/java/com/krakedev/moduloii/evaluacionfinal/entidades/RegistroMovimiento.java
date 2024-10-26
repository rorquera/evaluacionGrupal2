package com.krakedev.moduloii.evaluacionfinal.entidades;

import java.time.LocalDate;

public class RegistroMovimiento {
	private int id;
	private String idArticulo;
	private int stock;
	private LocalDate fechaMovimiento;

	public RegistroMovimiento() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(LocalDate fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	@Override
	public String toString() {
		return "RegistroMovimiento [id=" + id + ", idArticulo=" + idArticulo + ", stock=" + stock + ", fechaMovimiento="
				+ fechaMovimiento + "]";
	}

}
