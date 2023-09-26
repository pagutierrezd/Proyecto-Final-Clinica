package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;

public record DetalleAtencionMedicaDTO(
        int codigoCita,
        String nombrePaciente,

        String nombreMedico,

        String especialidad,

        LocalDateTime fechaAtencion,

        String tratamiento,

        String notasMedicas,

        String diagnostico) {






}
