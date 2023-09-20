package co.edu.uniquindio.clinica.servicios;

public interface CitaServicio {

    void agendarCita();

    void listarCitasPacientes();

    void verDetalleCita();

    void filtrarCitasPorFecha();

    void filtrarCitasPorMedico();

    void listarCitasPendientesMedico();

    void atenderCita();
}
