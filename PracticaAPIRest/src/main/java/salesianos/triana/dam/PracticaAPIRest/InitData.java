package salesianos.triana.dam.PracticaAPIRest;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InitData {

    private final GallipatoRepositorio repo;

    @PostConstruct
    public void loadInitData(){

    }
}
