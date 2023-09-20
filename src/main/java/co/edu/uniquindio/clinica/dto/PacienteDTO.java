package co.edu.uniquindio.clinica.dto;

import java.util.List;

public record PacienteDTO(
        String nombre,
        String cedula,
        int codigoCiudad,
        String telefono,
        String email,
        String contraseña,
        String urlFoto;

) {
}
