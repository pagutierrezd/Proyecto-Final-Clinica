package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaDTO(
        //No se declaran los argumentos del nombre y cedula del paciente, pues es él mismo quien esta haciendo la consulta de la cita
        String codigoCita,
        String nombreMedico,
        String especialidad,
        EstadoCita estadoCita,
        LocalDateTime fecha,
        String motivo
) {
}
