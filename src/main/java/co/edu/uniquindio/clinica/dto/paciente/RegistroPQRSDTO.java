package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.enums.TipoPQRS;

public record RegistroPQRSDTO(
        int codigoCita,
        String motivo,
        int codigoPaciente,
        TipoPQRS tipoPQRS
) {
}
