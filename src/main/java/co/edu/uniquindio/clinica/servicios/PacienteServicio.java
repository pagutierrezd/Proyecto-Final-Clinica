package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.PQRSPacienteDTO;
import co.edu.uniquindio.clinica.dto.PacienteDTO;

public interface PacienteServicio {

    String registrarse(PacienteDTO)throws Exception;

    String editarPerfil(int codigo,PacienteDTO);

    String eliminarCuenta(int codigo);

    void enviarLinkRecuperacion();

    void cambiarPassword();

    void agendarCita();

    String crearPQRS(PQRSPacienteDTO) throws Exception;

    void listarPQRSPaciente();

    void responderPQRS();

    void listarCitasPaciente();

    void filtrarCitasPorFecha();

    void filtrarCitasPorMedico();

    void verDetalleCita();

}


