package com.krakedev.moduloii.evaluacionfinal.servicios;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.evaluacionfinal.entidades.Articulo;
import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

public class ServiciosArticulo {
	private static Logger logger = LogManager.getLogger(ServiciosArticulo.class);

	public static void insertar(Articulo articulo) throws InventarioException {
		Connection conn = null;
		try {
			conn = ConexionBDD.obtenerConexion();

			String sqlArticulo = "INSERT INTO public.articulos(id, nombre, precio_venta, precio_compra, id_grupo) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement pstmtArt = conn.prepareStatement(sqlArticulo);

			// Datos a insertar para articulos
			String id = articulo.getId();
			String nombre = articulo.getNombre();
			BigDecimal precioVenta = articulo.getPrecioVenta();
			BigDecimal precioCompra = articulo.getPrecioCompra();
			String idGrupo = articulo.getIdGrupo();

			// Establecer los valores de los parámetros para articulos
			pstmtArt.setString(1, id);
			pstmtArt.setString(2, nombre);
			pstmtArt.setBigDecimal(3, precioVenta);
			pstmtArt.setBigDecimal(4, precioCompra);
			pstmtArt.setString(5, idGrupo);

			// Ejecutar la sentencia para articulos
			int filasArticulos = pstmtArt.executeUpdate();
			System.out.println("Filas insertadas articulos: " + filasArticulos);
		} catch (SQLException e) {
			logger.info("Error al intentar guardar los datos. " + e.getMessage());
			throw new InventarioException("Error al intentar guardar los datos.");
		} catch (InventarioException e) {
			logger.info("Error inesperado al guardar los datos. " + e.getMessage());
			throw e;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.info("Error al cerrar la conexion. " + e.getMessage());
				throw new InventarioException("Error al cerrar la conexion.");
			}
		}
	}

	public static void actualizar(Articulo articulo) throws InventarioException {
		Connection conn = null;
		try {
			conn = ConexionBDD.obtenerConexion();

			String sqlArticulo = "UPDATE public.articulos SET nombre=?, precio_venta=?, precio_compra=?, id_grupo=? WHERE id=?";

			PreparedStatement pstmtArt = conn.prepareStatement(sqlArticulo);

			// Datos a insertar para articulos
			String id = articulo.getId();
			String nombre = articulo.getNombre();
			BigDecimal precioVenta = articulo.getPrecioVenta();
			BigDecimal precioCompra = articulo.getPrecioCompra();
			String idGrupo = articulo.getIdGrupo();

			// Establecer los valores de los parámetros para articulos
			pstmtArt.setString(5, id);
			pstmtArt.setString(1, nombre);
			pstmtArt.setBigDecimal(2, precioVenta);
			pstmtArt.setBigDecimal(3, precioCompra);
			pstmtArt.setString(4, idGrupo);

			// Ejecutar la sentencia para articulos
			int filasArticulos = pstmtArt.executeUpdate();
			System.out.println("Filas afectadas articulos: " + filasArticulos);
		} catch (SQLException e) {
			logger.info("Error al intentar actualizar los datos. " + e.getMessage());
			throw new InventarioException("Error al intentar actualizar los datos.");
		} catch (InventarioException e) {
			logger.info("Error inesperado al actualizar los datos. " + e.getMessage());
			throw e;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.info("Error al cerrar la conexion. " + e.getMessage());
				throw new InventarioException("Error al cerrar la conexion.");
			}
		}
	}

	public static Articulo buscarPorId(String id) throws InventarioException {
		Articulo articulo = new Articulo();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConexionBDD.obtenerConexion();

			String sqlArticulo = "SELECT id, nombre, CAST(precio_venta AS numeric) AS precio_venta, CAST(precio_compra AS numeric) AS precio_compra, id_grupo FROM public.articulos where id=?";

			PreparedStatement pstmtArt = conn.prepareStatement(sqlArticulo);

			// Establecer los valores de los parámetros para articulos
			pstmtArt.setString(1, id);

			// Ejecutar la sentencia para articulos
			rs = pstmtArt.executeQuery();

			// Obtener los valores del ResultSet
			if (rs.next()) {
				articulo.setId(id);
				articulo.setNombre(rs.getString("nombre"));
				articulo.setPrecioVenta(rs.getBigDecimal("precio_venta"));
				articulo.setPrecioCompra(rs.getBigDecimal("precio_compra"));
				articulo.setIdGrupo((rs.getString("id_grupo")));
			}
		} catch (SQLException e) {
			logger.info("Error al intentar recuperar los datos. " + e.getMessage());
			e.printStackTrace();
			throw new InventarioException("Error al intentar recuperar los datos.");
		} catch (InventarioException e) {
			logger.info("Error inesperado al recuperar los datos. " + e.getMessage());
			throw e;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.info("Error al cerrar la conexion. " + e.getMessage());
				throw new InventarioException("Error al cerrar la conexion.");
			}
		}
		return articulo;
	}

	public static List<Articulo> recuperarTodos() throws InventarioException {
		List<Articulo> articulos = new ArrayList<Articulo>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Articulo articulo = null;
		String sql = "SELECT id, nombre, CAST(precio_venta AS numeric) AS precio_venta, CAST(precio_compra AS numeric) AS precio_compra, id_grupo FROM public.articulos";
		try {
			conn = ConexionBDD.obtenerConexion();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String nombre = rs.getString("nombre");
				BigDecimal precioVenta = rs.getBigDecimal("precio_venta");
				BigDecimal precioCompra = rs.getBigDecimal("precio_compra");
				String idGrupo = rs.getString("id_grupo");
				articulo = new Articulo();
				articulo.setId(id);
				articulo.setNombre(nombre);
				articulo.setPrecioVenta(precioVenta);
				articulo.setPrecioCompra(precioCompra);
				articulo.setIdGrupo(idGrupo);
				articulos.add(articulo);
			}
		} catch (InventarioException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InventarioException("Error al consultar. Detalle: " + e.getMessage());
		}
		return articulos;
	}

}
