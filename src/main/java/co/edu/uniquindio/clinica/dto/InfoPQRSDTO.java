package co.edu.uniquindio.clinica.dto;

public record InfoPQRSDTOAdmin(
        int codigo,
        String estado,
        int codigoCita,
        String motivo,
        String nombrePaciente,
        LocalDateTime fecha,
        List<String> mensajes

) {
}
