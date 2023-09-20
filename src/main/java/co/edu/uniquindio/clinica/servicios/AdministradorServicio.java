package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.*;

import java.util.List;

public interface AdministradorServicio {

    String crearMedico(MedicoDTO medico) throws Exception; // Deben ir como parametros los atributos que estan en el formulario(mockups)


    String actualizarMedico(int codigo, MedicoDTO medico) throws Exception;

    String eliminarMedico(int codigo) throws Exception;

     List<MedicoDTOAdmin> ListarMedicos() throws Exception;

    InfoMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<PQRSDTOAdmin> listarPQRS() throws Exception;

    String responderPQRS(int codigo) throws Exception;

    InfoPQRSDTO verDetallePQRS(int codigo) throws Exception;

    List<CitaDTOAdmin> listarCitas() throws Exception;








}
