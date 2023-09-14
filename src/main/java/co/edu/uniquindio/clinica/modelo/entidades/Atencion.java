package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Atencion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String diagnostico;

    private String tratamiento;

    private String notasMedicas;

    private String asignacionEspecialista; //O se le asigna la enumeracion de especialidad?

    @OneToOne
    private Cita cita;

    @OneToOne
    private Cita citaAsignada;
}
