package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


@SpringBootTest
public class MedicoServicioTest {




        @Autowired
        private MedicoServicio medicoServicio;

        @Test
        public void listarCitasPendientesTest() throws Exception{

                RegistroPacienteDTO pacienteDTO = new RegistroPacienteDTO(
                        "1097222222",
                        "Pepito Perez",
                        "3243434",
                        "aquí va la url de la foto",
                        Ciudad.ARMENIA,
                        LocalDate.of(1990, 10, 7),
                        "El polvo y el polen me hacen estornudar",
                        EPS.NUEVA_EPS,
                        TipoSangre.A_POSITIVO,
                        "pepitoperez@email.com",
                        "12345678");

//Guardamos el registro usando el método del servicio
                int nuevo = pacienteServicio.registrarse(pacienteDTO);
//Comprobamos que sí haya quedado guardado. Si se guardó debe retornar el código (no 0).

                12

                Universidad del Quindío
                Programa de Ingeniería de Sistemas y Computación
                Programación Avanzada - Capa de Negocio
                Septiembre de 2023
                Assertions.assertNotEquals(0, nuevo);
        }



}


