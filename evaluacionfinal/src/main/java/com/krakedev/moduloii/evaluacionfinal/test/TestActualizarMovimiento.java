package com.krakedev.moduloii.evaluacionfinal.test;

import java.time.LocalDate;

import com.krakedev.moduloii.evaluacionfinal.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosMovimiento;

public class TestActualizarMovimiento {
	public static void main(String[] args) {
		try {
			String idArticulo = "A0002";
			int stock = 10;
			LocalDate fecha = LocalDate.of(2024, 10, 20);
			int id=12;

			RegistroMovimiento gr = new RegistroMovimiento();
			gr.setIdArticulo(idArticulo);
			gr.setStock(stock);
			gr.setFechaMovimiento(fecha);
			gr.setId(id);
			ServiciosMovimiento.actualizarMovimientos(gr);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
