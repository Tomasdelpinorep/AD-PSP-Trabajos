package com.salesianostriana.dam.APIRestCompletaLugares;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Lugar {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String tags;
}
