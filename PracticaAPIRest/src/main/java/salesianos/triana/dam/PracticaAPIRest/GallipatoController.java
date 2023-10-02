package salesianos.triana.dam.PracticaAPIRest;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GallipatoController {

    private final GallipatoRepositorio repo;

    @GetMapping("/gallipato/")
    public ResponseEntity<List<Gallipato>> getAll(){
        List<Gallipato> result = repo.findAll();

        if(result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/gallipato/{id}")
    public ResponseEntity<Gallipato> getById(@PathVariable Long id){
       return ResponseEntity.of(repo.findById(id));
    }

    @PostMapping("/gallipato/")
    public ResponseEntity<Gallipato> createGallipato(@RequestBody Gallipato gallipato){
        Gallipato nuevo = repo.save(gallipato);

        return ResponseEntity.status(201).body(gallipato);
    }

    @PutMapping("/gallipato/{id}")
    public ResponseEntity<Gallipato> editGallipato(@PathVariable Long id, @RequestBody Gallipato editado){
    return ResponseEntity.of(repo.findById(id)
            .map(antiguo -> {
                antiguo.setNombre(editado.getNombre());
                return repo.save(antiguo);
            }));
    }

    @DeleteMapping("/gallipato/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(repo.existsById(id))
            repo.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("gallipato/{id}/tag/add/{new}")
    public ResponseEntity<Gallipato> addTag(@PathVariable Long id, @PathVariable String nuevoTag){
        return ResponseEntity.of(repo.findById(id)
                .map(gallipato -> {
                    if( !gallipato.getTags().contains(nuevoTag))
                        gallipato.setTags(gallipato.getTags() + ", " + nuevoTag);
                    return repo.save(gallipato);
                }));
    }

    @PutMapping("gallipato/{id}/tag/add/{eliminar}")
    public ResponseEntity<Gallipato> deleteTag(@PathVariable Long id, @PathVariable String eliminar){
        return ResponseEntity.of(repo.findById(id)
                .map(gallipato -> {
                    String tags = gallipato.getTags();
                    tags = Arrays.stream(tags.split(","))
                            .map(String::trim)
                            .filter(tag -> !tag.equalsIgnoreCase(eliminar))
                            .collect(Collectors.joining(","));

                    gallipato.setTags(tags);

                    return repo.save(gallipato);
                    })
        );
    }
}
