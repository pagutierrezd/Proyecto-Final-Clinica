package co.edu.uniquindio.clinica.dto.medico;

import java.time.LocalDateTime;

public record RegistroAtencionDTO(
        int codigoCita,
        int codigoMedico,
        String notasMedicas,
        String tratamiento,
        String diagnostico,
        boolean asignaciónEspecialista
) {
}
