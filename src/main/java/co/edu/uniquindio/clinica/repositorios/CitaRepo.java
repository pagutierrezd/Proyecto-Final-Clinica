package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Cita;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;
import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Integer> {

    Cita findByCodigo(int codigo);




    List<Cita> findAllByMedicoCodigo(int codigoMedico);


    List<Cita> findByPacienteCodigo(int codigoPaciente);
}
