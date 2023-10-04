package model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Direccion {

    @Id
    @GeneratedValue
    private Long id;

    private String tipoVia,linea1,linea2,cp,poblacion,provincia;
}
