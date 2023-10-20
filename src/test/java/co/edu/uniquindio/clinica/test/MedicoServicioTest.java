package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;


@SpringBootTest
public class MedicoServicioTest {


        @Autowired
        private MedicoServicio medicoServicio;

        @Test
        public void testListarCitasPendientes() throws Exception {

                // Llama al método de servicio y verifica los resultados
                List<ItemCitaAdminDTO> citasPendientes = medicoServicio.listarCitasPendientes(1);

                Assertions.assertNotEquals(0, citasPendientes.size());
                // Verifica que no haya citas pendientes
        }



}


