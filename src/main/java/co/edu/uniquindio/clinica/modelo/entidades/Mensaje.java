package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mensaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private LocalDateTime fechaCreacion;

    private String mensaje;

    @ManyToOne
    private PQRS pqrs;

    @ManyToOne
    private Cuenta cuenta;

    @OneToOne
    @JoinColumn(name = "mensajeAnterior") //Relación de la clase con sigo misma
    private Mensaje mensajeAnterior;
}
