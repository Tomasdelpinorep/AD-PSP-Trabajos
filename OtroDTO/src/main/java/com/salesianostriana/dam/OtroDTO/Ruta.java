package com.salesianostriana.dam.OtroDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ruta {

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private int tiempo; //en minutos

    @Enumerated(EnumType.STRING)
    private Dificultad dificultad;

    @OneToMany //Una ruta, muchos monumentos
    private List<Monumento> monumento;
}
