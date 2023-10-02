package salesianos.triana.dam.MonumentosMundoTomasDelPino;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Monumento {
    @Id // No has añadido @GeneratedValue. Los id numéricos no autogenerados no son recomendables
    private Long id;

    private String cod;
    private String ciudad;
    private String pais;
    private String nombre;
    private String descripcion;
    private String Url;
    private Double [] localizacion;

}
