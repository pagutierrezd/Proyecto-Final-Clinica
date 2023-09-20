package co.edu.uniquindio.clinica.modelo.enums;

public enum TipoPQRS {

    PETICIONES("Peticiones"),
    QUEJAS("Quejas"),
    RECLAMOS("Reclamos"),
    SUGERENCIAS("Sugerencias");

    private String nombre;

    TipoPQRS(String nombre) {this.nombre = nombre;}
}
