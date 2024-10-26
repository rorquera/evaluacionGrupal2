package com.krakedev.moduloii.evaluacionfinal.test;

import java.time.LocalDate;

import com.krakedev.moduloii.evaluacionfinal.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosGrupo;

public class TestInsertarMovimiento {
	public static void main(String[] args) {
		try {
			String idArticulo = "A0001";
			int stock = 10;
			LocalDate fecha = LocalDate.of(2023, 11, 22);

			RegistroMovimiento gr = new RegistroMovimiento();
			gr.setIdArticulo(idArticulo);
			gr.setStock(stock);
			gr.setFechaMovimiento(fecha);
			ServiciosGrupo.insertarMovimientos(gr);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
