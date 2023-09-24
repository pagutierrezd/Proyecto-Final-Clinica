package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.RegistroMedicoDTO;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(RegistroMedicoDTO medico) throws Exception;

    int actualizarMedico(int codigo, RegistroMedicoDTO medico) throws Exception;

    void eliminarMedico(int codigo) throws Exception;

    List<ItemMedicoDTO> ListarMedicos() throws Exception;

    DetalleMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<ItemPQRSDTO> listarPQRS() throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

    List<ItemCitaDTO> listarCitas() throws Exception;
}
