package com.salesianostriana.dam.APIRestCompletaLugares;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lugar")
public class LugarController {

    private final LugarRepository repo;

    @GetMapping("/")
    public ResponseEntity<List<Lugar>> getAll() {
        List<Lugar> all = repo.findAll();

        if (all.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lugar> getById(@PathVariable Long id) {
        return ResponseEntity.of(repo.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Lugar> addNew(@RequestBody Lugar nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lugar> edit(@PathVariable Long id, @RequestBody Lugar lugarActualizado) {
        return ResponseEntity.of(repo.findById(id)
                .map(antiguo -> {
                    antiguo.setNombre(lugarActualizado.getNombre());
                    return antiguo;
                }));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lugar> delete(@PathVariable Long id) {
        if (!repo.existsById(id))
            repo.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/tag/add/{nuevo}")
    public ResponseEntity<Lugar> addNewTag(@PathVariable Long id, @PathVariable String newTag) {

        return ResponseEntity.of(
                repo.findById(id).map(lugar -> {
                    if (!lugar.getTags().contains(newTag)) {
                        lugar.setTags(lugar.getTags() + ", " + newTag);
                        return repo.save(lugar);
                    }

                    return lugar;
                })
        );
    }

    @PutMapping("/{id}/tag/del/{eliminar}")
    public ResponseEntity<Lugar> deleteTag(@PathVariable Long id, @PathVariable String eliminar){
        return ResponseEntity.of(
                repo.findById(id).map(lugar -> {
                    String tags = lugar.getTags();

                    tags = Arrays.stream(tags.split(","))
                            .map(String::trim)
                            .filter(tag -> !tag.equalsIgnoreCase(eliminar))
                            .collect(Collectors.joining(","));

                    lugar.setTags(tags);

                    return repo.save(lugar);
                })
        );
    }

}
