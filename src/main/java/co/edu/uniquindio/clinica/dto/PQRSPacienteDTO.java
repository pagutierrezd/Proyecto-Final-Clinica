package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Mensaje;
import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;
import co.edu.uniquindio.clinica.modelo.enums.TipoPQRS;

import java.time.LocalDateTime;
import java.util.List;

public record PQRSPacienteDTO(int codigo, LocalDateTime fechaCreacion, String motivo, String tipoPQRS,
                              String estadoPQRS, String cita, List<Mensaje> mensajes) {
}
