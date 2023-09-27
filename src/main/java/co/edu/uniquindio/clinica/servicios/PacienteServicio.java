package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.*;

import java.util.List;

public interface PacienteServicio {

    String registrarse(PacienteDTO pacienteDTO)throws Exception;

    String editarPerfil(int codigo,PacienteDTO pacienteDTO) throws Exception;

    String eliminarCuenta(int codigo)throws Exception;

    void enviarLinkRecuperacion(String email) throws Exception;

    void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;

    void agendarCita(RegistroCitaDTO registroCitaDTO)throws Exception;

    String crearPQRS(PQRSPacienteDTO pqrsPacienteDTO) throws Exception;

    List<InfoPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;

    void responderPQRS(RespuestaDTO respuestaDTO)throws Exception;

    List<InfoCitasDTO>listarCitasPaciente(int codigoPaciente)throws Exception;

    FiltroBusquedaFechaDTO filtrarCitasPorFecha()throws Exception;

     FiltroBusquedaMedicoDTO filtrarCitasPorMedico(int codigoMedico) throws Exception;

    DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws Exception;

}


