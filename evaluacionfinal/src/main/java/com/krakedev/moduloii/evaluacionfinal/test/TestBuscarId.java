package com.krakedev.moduloii.evaluacionfinal.test;

import com.krakedev.moduloii.evaluacionfinal.entidades.Articulo;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosArticulo;

public class TestBuscarId {
	public static void main(String[] args) {
		try {
			Articulo articulo = ServiciosArticulo.buscarPorId("A0001");
			System.out.println(articulo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
