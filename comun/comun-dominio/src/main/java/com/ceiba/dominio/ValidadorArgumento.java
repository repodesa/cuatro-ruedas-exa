package com.ceiba.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ceiba.dominio.excepcion.ExcepcionFechaHora;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ValidadorArgumento {

    public static final int HORA_INICIAL_VALIDA = 6;
    public static final int HORA_FINAL_VALIDA = 17;
    public static final int MINUTO_INICIAL_VALIDA = 0;
    public static final int MINUTO_FINAL_VALIDA = 59;
    private static final String HORA_ENTRADA_MAYOR_HORA_SALIDA = "No se permiten registrar horas de entradas posteriores a las horas de salidas o viceversa.";
    private static final String DEFINA_UN_HORARIO_PARA_LA_CITA = "El horario para la agenda debe ser definido.";

    private ValidadorArgumento() {
    }

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }

    public static void validarLongitud(String valor, int longitud, String mensaje) {
        if (valor.length() < longitud) {
            throw new ExcepcionLongitudValor(mensaje);
        }
    }

    public static <T> void validarNoVacio(List<T> lista, String mensaje) {
        if (lista.isEmpty()) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }

    public static void validarPositivo(Double valor, String mensaje) {
        if (valor <= 0) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarIgual(Double valor, Double valorEsperado, String mensaje) {
        if (!valor.equals(valorEsperado)) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarLongitudMinima(Object valor, int longitudMinima, String mensaje) {
        if (valor.toString().length() < longitudMinima) {
            throw new ExcepcionLongitudValor(mensaje);
        }
    }

    public static void validarMenor(LocalDateTime fechaInicial, LocalDateTime fechaFinal, String mensaje) {
        if (fechaInicial.toLocalDate().isAfter(fechaFinal.toLocalDate())) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarMenor(Long numeroInicial, Long numeroFinal, String mensaje) {
        if (numeroInicial > numeroFinal) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void validarRegex(String correoElectronico, String regex, String mensaje) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correoElectronico);

        if (!matcher.matches()) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static <E extends Enum<E>> E validarValido(String valor, Class<E> enumAObtener, String mensaje) {
        E enumObtenido = null;
        if (null != valor) {
            Optional<E> resultadoOpcional = Arrays.stream(enumAObtener.getEnumConstants())
                    .filter(resultado -> resultado.toString().equals(valor)).findFirst();

            if (resultadoOpcional.isPresent()) {
                enumObtenido = resultadoOpcional.get();
            } else {
                throw new ExcepcionValorInvalido(mensaje);
            }
        }
        return enumObtenido;
    }

    public static void validarNumerico(String valor, String mensaje) {
        try {
            Long.parseLong(valor);
        } catch (NumberFormatException numberFormatException) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    // Validaciones Clase Cita
    public static void fechaEntradaMayorQueFechaRegistro(LocalDate agenfeen, String mensaje) {
        if (agenfeen.isBefore(LocalDate.now())) {
            throw new ExcepcionFechaHora(mensaje);
        }
    }

    public static void fechaSalidaMayorQueFechaRegistro(LocalDate agenfesa, String mensaje) {
        if (agenfesa.isBefore(LocalDate.now())) {
            throw new ExcepcionFechaHora(mensaje);
        }
    }

    public static void valorDiferenteNuloMayorCero(Double valocita, String mensaje) {
        if (valocita == null || valocita <= 0.0) {
            throw new ExcepcionValorInvalido(mensaje);
        }
    }

    public static void horaEntradaRangoValido(LocalTime ltHoraEntr, LocalTime ltHoraSali, String mensaje) {
        if (ltHoraEntr != null && ltHoraSali != null) {
            if (horaValida(ltHoraEntr) || horaValida(ltHoraSali)) {
                throw new ExcepcionFechaHora(mensaje + HORA_INICIAL_VALIDA + ":00 a " + HORA_FINAL_VALIDA + ":00.");
            }
        } else {
            throw new ExcepcionFechaHora(DEFINA_UN_HORARIO_PARA_LA_CITA);
        }
        horaEntradaVsHoraSalida(ltHoraEntr, ltHoraSali);
    }

    public static boolean horaValida(LocalTime ltHora) {
        return (
                (ltHora.getHour() < HORA_INICIAL_VALIDA || ltHora.getHour() > HORA_FINAL_VALIDA) ||
                        (ltHora.getMinute() < MINUTO_INICIAL_VALIDA && ltHora.getMinute() > MINUTO_FINAL_VALIDA)
        );
    }

    public static void horaEntradaVsHoraSalida(LocalTime ltHoraEntr, LocalTime ltHoraSali) {
        if (ltHoraEntr.isAfter(ltHoraSali) || ltHoraSali.isBefore(ltHoraEntr)) {
            throw new ExcepcionFechaHora(HORA_ENTRADA_MAYOR_HORA_SALIDA);
        }
    }
}
