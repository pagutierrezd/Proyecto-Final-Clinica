package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.dto.HorarioDTO;

import java.util.List;

public record RegistroMedicoDTO(
        String cedula,
        String nombre,
        int codigoCiudad,
        int codigoEspecialidad,
        String telefono,
        String email,
        String password,
        List<HorarioDTO> horarios
) {
}
