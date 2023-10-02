package salesianos.triana.dam.PracticaAPIRest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gallipato {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String tags;
}
