package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.Especialidad;

import java.util.List;

public record RegistroMedicoDTO(
        String cedula,
        String nombre,
        Ciudad ciudad,
        Especialidad especialidad,
        String telefono,
        String email,
        String password,
        String urlFoto,
        List<HorarioDTO> horarios
) {
}
