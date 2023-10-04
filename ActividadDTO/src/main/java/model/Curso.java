package model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Curso {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre,tipo,tutor,aula;
}
