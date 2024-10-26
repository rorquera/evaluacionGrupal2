package com.krakedev.moduloii.evaluacionfinal.servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.evaluacionfinal.entidades.Grupo;
import com.krakedev.moduloii.evaluacionfinal.entidades.RegistroMovimiento;
import com.krakedev.moduloii.evaluacionfinal.excepciones.InventarioException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

public class ServiciosMovimiento {
	private static Logger logger = LogManager.getLogger(ServiciosArticulo.class);
	public static void actualizarGrupo(Grupo grupo) throws InventarioException {
		Connection conn = null;
		try {
			conn = ConexionBDD.obtenerConexion();

			String sqlArticulo = "UPDATE public.grupos SET nombre=? WHERE id=?";

			PreparedStatement pstmtArt = conn.prepareStatement(sqlArticulo);

			// Datos a insertar para articulos
			String id = grupo.getId();
			String nombre = grupo.getNombre();

			// Establecer los valores de los parámetros para articulos
			pstmtArt.setString(1, nombre);
			pstmtArt.setString(2, id);

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
	
	public static void actualizarMovimientos(RegistroMovimiento registoMovimiento) throws InventarioException {
		Connection conn = null;
		try {
			conn = ConexionBDD.obtenerConexion();

			String sqlArticulo = "UPDATE public.registro_movimientos SET id_articulo=?, stock=?, fecha_movimiento=? WHERE id=?";

			PreparedStatement pstmtArt = conn.prepareStatement(sqlArticulo);

			// Datos a insertar para articulos
			int id = registoMovimiento.getId();
			String idArticulo = registoMovimiento.getIdArticulo();
			int stock = registoMovimiento.getStock();
			LocalDate fecha = registoMovimiento.getFechaMovimiento();

			// Establecer los valores de los parámetros para articulos
			pstmtArt.setString(1, idArticulo);
			pstmtArt.setInt(2, stock);
			pstmtArt.setDate(3, Date.valueOf(fecha));
			pstmtArt.setInt(4, id);

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
}