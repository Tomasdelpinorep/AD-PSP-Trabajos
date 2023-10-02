package salesianos.triana.dam.MonumentosMundoTomasDelPino;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// En el ejemplo que hemos realizado en clase antes de realizar este ejercicio, el repositorio
// ya era una extensión de JpaRepository para que pudiera almacenarse todo en una base de datos.

@Repository
public class MonumentoRepositorio {
    private List<Monumento> monumentos;

    public MonumentoRepositorio(){

        monumentos = new ArrayList<>();

        monumentos.add(
                Monumento.builder()
                        .nombre("Torre Mocha 1")
                        .cod("ES")
                        .ciudad("Albaida")
                        .pais("Espana")
                        .descripcion("Una torre muy bella")
                        .url("www.torremocha.com")
                        .localizacion(new double[]{100.00, 100.00})
                        .build()
        );
        monumentos.add(
                Monumento.builder()
                        .nombre("Torre Mocha 2")
                        .cod("ES")
                        .ciudad("Albaida")
                        .pais("Espana")
                        .descripcion("Una torre muy bella")
                        .url("www.torremocha.com")
                        .localizacion(new double[]{100.00, 100.00})
                        .build()
        );
        monumentos.add(
                Monumento.builder()
                        .nombre("Torre Mocha 3")
                        .cod("ES")
                        .ciudad("Albaida")
                        .pais("Espana")
                        .descripcion("Una torre muy bella")
                        .url("www.torremocha.com")
                        .localizacion(new double[]{100.00, 100.00})
                        .build()
        );
    }
    public List<Monumento> findALll(){
        return Collections.unmodifiableList(monumentos);
    }
}
