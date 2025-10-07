package jeancarlo_moya_1b.jeancarlomoya1b.Controller;

import jeancarlo_moya_1b.jeancarlomoya1b.Models.DTO.PeliculaDTO;
import jeancarlo_moya_1b.jeancarlomoya1b.Services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiPeliculas")
@CrossOrigin
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping("/datosPeliculas")
    public ResponseEntity<List<PeliculaDTO>> obtenerTodos(){
        System.out.println("hola ya entre al fin");
        List<PeliculaDTO> peliculas = peliculaService.listarTodos();
        return ResponseEntity.ok(peliculas);
    }
}
