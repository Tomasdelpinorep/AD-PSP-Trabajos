package com.salesianostriana.dam.OtroDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monumento {
    @Id @GeneratedValue
    private Long id;

    private String codigoPais, pais, ciudad, loc, nombre, descripcion, urlImagen;

    @ManyToOne
    private Categoria categoria;

    @ElementCollection //Solo necesario en SB2
    private ArrayList<> ;
}
