package com.krakedev.moduloii.evaluacionfinal.test;

import com.krakedev.moduloii.evaluacionfinal.entidades.Grupo;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosMovimiento;

public class TestActualizarGrupo {
	public static void main(String[] args) {
		try {
			String id = "G004";
			String nombre = "medicina";

			Grupo gr = new Grupo();
			gr.setId(id);
			gr.setNombre(nombre);
			ServiciosMovimiento.actualizarGrupo(gr);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
