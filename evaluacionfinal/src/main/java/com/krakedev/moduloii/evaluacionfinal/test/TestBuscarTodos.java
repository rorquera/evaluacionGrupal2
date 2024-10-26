package com.krakedev.moduloii.evaluacionfinal.test;

import java.util.List;

import com.krakedev.moduloii.evaluacionfinal.entidades.Articulo;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosArticulo;

public class TestBuscarTodos {
	public static void main(String[] args) {
		try {
			List<Articulo> articulos = ServiciosArticulo.recuperarTodos();
			System.out.println(articulos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
