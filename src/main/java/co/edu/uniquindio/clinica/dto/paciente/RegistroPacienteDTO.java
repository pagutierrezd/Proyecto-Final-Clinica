package co.edu.uniquindio.clinica.dto.paciente;

import java.time.LocalDateTime;

public record RegistroPacienteDTO(
        String cedula,
        String nombre,
        String telefono,
        String urlFoto,
        int codigoCiudad,
        LocalDateTime fechaNacimiento,
        String alergias,
        int codigoEPS
) {
}
