package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.DetalleAtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Atencion;
import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;
import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;
import co.edu.uniquindio.clinica.repositorios.AtencionRepo;
import co.edu.uniquindio.clinica.repositorios.CitaRepo;
import co.edu.uniquindio.clinica.repositorios.MedicoRepo;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final MedicoRepo medicoRepo;
    private final CitaRepo citaRepo;
    private final AtencionRepo atencionRepo;

@Override
// Listar las citas que el medico tiene pendiente
   public List<ItemCitaAdminDTO> listarCitasPendientes(int codigoMedico,EstadoCita estadoCita) throws Exception{


       List<Cita> citasPendientes =citaRepo.findAllByMedicoCodigoAndEstadoCita(codigoMedico,estadoCita);
       if (citasPendientes.isEmpty())
       {
           throw new Exception("No hay citas pendientes para el médico" + codigoMedico);
       }

        List<ItemCitaAdminDTO>  respuesta = new ArrayList<>();

        for (Cita c : citasPendientes) {
            respuesta.add(new ItemCitaAdminDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecialidad().name(),
                    c.getEstadoCita(),
                    c.getFechaCita()

            ));
        }

            return respuesta;


        }



        @Override
// Registar notas medicas,tratamniento ,asignacion especialista al hacer una consulta
    public int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception{

        Optional<Atencion> atenciones = atencionRepo.findById(registroAtencionDTO.codigoCita());

        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        if(atenciones.isEmpty()){
            throw new Exception("No existen citas creadas");
        }

        Atencion buscado = atenciones.get();

                    buscado.setNotasMedicas(registroAtencionDTO.notasMedicas());
                    buscado.setTratamiento(registroAtencionDTO.tratamiento());
                    buscado.setDiagnostico(registroAtencionDTO.diagnostico());
                    buscado.setAsignacionEspecialista(registroAtencionDTO.asignaciónEspecialista());


        atencionRepo.save( buscado );

        return buscado.getCodigo();



    }


// Listar historial medico del paciente
    public List<ItemCitaAdminDTO> listarHistorialAtencionesPaciente(int codigoPaciente) throws Exception{

        List<Cita> listaCitas = citaRepo.findByPacienteCodigo(codigoPaciente);
        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        for (Cita c : listaCitas) {

            respuesta.add(new ItemCitaAdminDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecialidad().name(),
                    c.getEstadoCita(),
                    c.getFechaCita()
            ));
        }
        return respuesta;
    }










@Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {


        // Verificar si el médico existe
        Optional<Medico> opcional = medicoRepo.findById(diaLibreDTO.codigoMedico());


        if (opcional.isEmpty()) {
            throw new Exception("El médico no existe.");
        }

        Medico buscado = opcional.get();

        // Verificar si ya existe un día libre activo para el médico
        if (buscado.getDiaLibres().isEmpty() && buscado.getDiaLibres().equals(diaLibreDTO.fecha())) {
            throw new Exception("El médico ya tiene un día libre activo.");
        }


        // Verificar si hay citas agendadas para la fecha que se quiere dejar libre
        List<Cita> citasAgendadas = citaRepo.findAllByMedicoCodigo(diaLibreDTO.codigoMedico());
        if (!citasAgendadas.isEmpty()) {
            throw new Exception("No se puede registrar un día libre si ya hay citas agendadas.");
        }

        // Verificar si el día libre a agendar es el día libre activo para el médico
        if (buscado.getDiaLibres() == null || !buscado.getDiaLibres().equals(diaLibreDTO.fecha())) {
            throw new Exception("No se puede agendar un día libre que no coincide con el día libre activo del médico.");
        }


        buscado.setDiaLibres(opcional.get().getDiaLibres());

        medicoRepo.save(buscado);

        return buscado.getCodigo();


    }





@Override
  public List<ItemCitaAdminDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception{


        List<Cita> citasDelMedico = citaRepo.findAllByMedicoCodigo(codigoMedico);

        if (citasDelMedico.isEmpty()) {
            throw new Exception("No hay citas para este médico.");
        }


        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        for (Cita cita : citasDelMedico) {
            respuesta.add(new ItemCitaAdminDTO(
                    cita.getCodigo(),
                    cita.getPaciente().getCedula(),
                    cita.getPaciente().getNombre(),
                    cita.getMedico().getNombre(),
                    cita.getMedico().getEspecialidad().name(),
                    cita.getEstadoCita(),
                    cita.getFechaCita()
            ));
        }

        return respuesta;
    }


@Override
   public DetalleAtencionMedicaDTO verDetalleAtencion(int codigoCita) throws Exception{

       Optional<Cita> opcional = citaRepo.findById(codigoCita);

       if (opcional.isEmpty()) {

           throw new Exception("No tiene registradas atenciones realizadas");
       }

       Cita cita = opcional.get();

       return new DetalleAtencionMedicaDTO(

          cita.getCodigo(),
              cita.getPaciente().getNombre(),
               cita.getMedico().getNombre(),
               cita.getMedico().getEspecialidad(),
               cita.getFechaCita(),
               cita.getAtencion().getTratamiento(),
               cita.getAtencion().getNotasMedicas(),
               cita.getAtencion().getDiagnostico()



       );
   }




}