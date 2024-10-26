package com.krakedev.moduloii.evaluacionfinal.test;

import com.krakedev.moduloii.evaluacionfinal.entidades.Grupo;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosGrupo;

public class TestInsertarGrupo {
	public static void main(String[] args) {
		try {
			String id = "G004";
			String nombre = "medicamentos";

			Grupo gr = new Grupo();
			gr.setId(id);
			gr.setNombre(nombre);
			ServiciosGrupo.insertarGrupo(gr);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
