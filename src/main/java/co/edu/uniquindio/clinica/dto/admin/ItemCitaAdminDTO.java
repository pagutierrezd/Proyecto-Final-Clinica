package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaAdminDTO(
        int codigoCita,
        String cedulaPaciente,
        String nombrePaciente,
        String nombreMedico,
        String especialidad,
        EstadoCita estadoCita,
        LocalDateTime fecha
) {
}
