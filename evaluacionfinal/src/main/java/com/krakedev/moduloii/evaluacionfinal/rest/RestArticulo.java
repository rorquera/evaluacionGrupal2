package com.krakedev.moduloii.evaluacionfinal.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.moduloii.evaluacionfinal.entidades.Articulo;
import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosArticulo;

@Path("funciones")
public class RestArticulo {
	@Path("probarInsertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Articulo articulo) {
		System.out.println("Articulo insertado: " + articulo);
		ServiciosArticulo sa=new ServiciosArticulo();
		try {
			sa.insertar(articulo);
			return Response.ok().build();
		} catch (InventarioException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
