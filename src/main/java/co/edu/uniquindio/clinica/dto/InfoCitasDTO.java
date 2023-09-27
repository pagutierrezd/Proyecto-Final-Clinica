package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;
public record InfoCitasDTO(

        int codigo,

        String estado,

        String nombrePaciente,


        String nombreMedico,


        LocalDateTime fecha,


        LocalDateTime fechaCreacion,

        String motivo

        ) {


}
