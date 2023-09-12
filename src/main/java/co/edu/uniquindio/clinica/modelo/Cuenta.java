package co.edu.uniquindio.clinica.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cuenta implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int codigo;

    private String email;

    private String password;

    @OneToMany(mappedBy = "cuenta") //Preguntar por esto!
    private List<Mensaje> mensajes;
}
