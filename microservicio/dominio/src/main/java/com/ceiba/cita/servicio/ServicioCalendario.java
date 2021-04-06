package com.ceiba.cita.servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicioCalendario {

	public static final int CANTIDAD_DIAS_HABILES_SABADOS = 2;
	public static final int CANTIDAD_DIAS_HABILES_DOMINGO = 1;
	private static final List<LocalDate> LISTA_DIAS_FESTIVOS = new ArrayList<>();

	private ServicioCalendario() {
	}

	/**
	 * 
	 * @param ldFecha
	 * @return
	 */
	public static Long diaHabilCalendario(LocalDate ldFecha) {
		Long inValoReto = (long) 0;
		if (ldFecha.getDayOfWeek().equals(DayOfWeek.SATURDAY) || ldFecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			if (ldFecha.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
				inValoReto = (long) CANTIDAD_DIAS_HABILES_DOMINGO;
				return inValoReto;
			} else {
				inValoReto = (long) CANTIDAD_DIAS_HABILES_SABADOS;
				return inValoReto;
			}
		}
		return inValoReto;
	}

	/**
	 * 
	 */
	private static void cargaFechasFestivas() {
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 1, 1));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 1, 11));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 3, 22));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 4, 1));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 4, 2));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 5, 1));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 5, 17));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 6, 7));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 6, 14));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 7, 5));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 7, 20));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 8, 7));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 8, 16));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 10, 18));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 11, 1));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 11, 15));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 12, 8));
		LISTA_DIAS_FESTIVOS.add(LocalDate.of(2021, 12, 25));
	}

	/**
	 * 
	 * @param ldFecha
	 * @return
	 */
	public static boolean esDiaFestivo(LocalDate ldFecha) {
		if (LISTA_DIAS_FESTIVOS.isEmpty()) {
			cargaFechasFestivas();
		}
		return (LISTA_DIAS_FESTIVOS.contains(ldFecha));
	}

}
