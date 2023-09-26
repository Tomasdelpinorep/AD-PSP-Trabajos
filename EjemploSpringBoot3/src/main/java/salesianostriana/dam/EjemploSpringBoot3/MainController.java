package salesianostriana.dam.EjemploSpringBoot3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/index")
    public String index(Model m){
        m.addAttribute("mensaje","esto es una prueba");

        return "index";
    }
}
