package com.krakedev.moduloii.evaluacionfinal.utils;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class Convertidor {
	private static final String FORMATO_FECHA = "yyyy/MM/dd hh:mm";

	public static Date convertirFecha(String fechaStr) throws Exception {
		SimpleDateFormat simplef = new SimpleDateFormat(FORMATO_FECHA);
		Date fechaDate = null;
		try {
			fechaDate = simplef.parse(fechaStr);
		} catch (ParseException e) {
			throw new Exception("La fecha no tiene el formato correcto");
		}
		return fechaDate;
	}
}
