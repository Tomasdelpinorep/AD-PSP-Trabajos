package model;

import jakarta.persistence.*;

public class Alumno {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, apellido1,apellido2, telefono, email;

    @OneToOne
    private Direccion direccion;

    @OneToMany
    private Curso curso;
}
