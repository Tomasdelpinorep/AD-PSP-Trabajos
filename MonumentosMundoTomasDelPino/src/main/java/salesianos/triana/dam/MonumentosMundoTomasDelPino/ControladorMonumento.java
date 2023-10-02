package salesianos.triana.dam.MonumentosMundoTomasDelPino;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorMonumento {

    private final MonumentoRepositorio monumentoRepositorio;

    @GetMapping("/monumentos")
    public ResponseEntity<List<Monumento>> getALll(){
        List<Monumento> result = monumentoRepositorio.findALll();

        if(result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/monumentos/{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id){
        return ResponseEntity.of(monumentoRepositorio.findById(id));
    }

    /*
        El método POST no es correcto. La implementación se parece
        un poco más a la del método PUT. Al crear con POST no
        deberíamos tener la obligación de proporcionar el ID en la ruta.
        Si acaso, si no autogeneramos el ID, debería ir en el propio monumento.

        Y el cuerpo del método debería añadir al repositorio, no buscar y editar.

     */
    @PostMapping("/monumentos/{id}")
    public ResponseEntity<Monumento> edit(@PathVariable Long id,
            @RequestBody Monumento actualizado) {
        return ResponseEntity.of(monumentoRepositorio.findById(id))
                .map(antiguo -> {
                    antiguo.setNombre(acutalizado.getNombre());
                });
    }

    // Está incompleto. Falta la implementación de los métodos de actualizar y borrar.
    // ¿Qué ha pasado? ¿Te ha faltado tiempo? Si ha sido por dudas, he estado a dos
    // metros tuyos los 45 minutos y no me has preguntado nada :(
}
