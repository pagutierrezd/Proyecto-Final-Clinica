package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;

public record ItemPQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivo,
        LocalDateTime fecha,
        String nombrePaciente
) {
}
