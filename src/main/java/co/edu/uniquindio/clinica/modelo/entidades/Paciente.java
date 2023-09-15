package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.modelo.enums.EPS;
import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Paciente extends Usuario implements Serializable {

    @Column(nullable = false)
    private LocalDateTime fechaNacimiento;

    @Column(nullable = false, length = 100)
    private String alergias;

    @Column(nullable = false)
    private EPS eps;

    @Column(nullable = false)
    private TipoSangre tipoSangre;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
}
