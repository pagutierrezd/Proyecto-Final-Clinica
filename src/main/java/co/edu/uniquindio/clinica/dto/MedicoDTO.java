package co.edu.uniquindio.clinica.dto;

import java.util.List;

public record MedicoDTO(
        String nombre,
        String cedula,
        int codigoCiudad,
        int codigoEspecialidad,
        String telefono,
        String email,
        String password,
        List<HorarioDTO> horarios
) {}
