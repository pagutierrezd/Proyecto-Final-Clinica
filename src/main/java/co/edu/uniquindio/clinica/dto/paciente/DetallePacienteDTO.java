package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.EPS;

import java.time.LocalDateTime;

public record DetallePacienteDTO(
        String cedula,
        String nombre,
        String telefono,
        Ciudad ciudad,
        LocalDateTime fechaNacimiento,
        String alergias,
        EPS eps
) {
}
