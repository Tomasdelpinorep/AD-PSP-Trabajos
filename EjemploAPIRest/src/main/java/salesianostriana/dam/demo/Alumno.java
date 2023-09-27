package salesianostriana.dam.demo;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Alumno {

    private int id;
    private String nombre, apellidos, email;
    private int edad;

}
