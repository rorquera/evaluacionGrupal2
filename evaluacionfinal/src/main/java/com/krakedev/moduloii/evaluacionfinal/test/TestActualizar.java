package com.krakedev.moduloii.evaluacionfinal.test;

import java.math.BigDecimal;

import com.krakedev.moduloii.evaluacionfinal.entidades.Articulo;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosArticulo;

public class TestActualizar {
	public static void main(String[] args) {
		try {
			String id = "A0011";
			String nombre = "pantaloneta";
			BigDecimal precioVenta = new BigDecimal("8.2");
			BigDecimal precioCompra = new BigDecimal("4");
			String idGrupo = "G003";

			Articulo articulo=new Articulo();
			articulo.setId(id);
			articulo.setNombre(nombre);
			articulo.setPrecioVenta(precioVenta);
			articulo.setPrecioCompra(precioCompra);
			articulo.setIdGrupo(idGrupo);
			ServiciosArticulo.actualizar(articulo);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
