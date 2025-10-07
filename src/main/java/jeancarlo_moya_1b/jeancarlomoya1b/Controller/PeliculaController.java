package jeancarlo_moya_1b.jeancarlomoya1b.Controller;

import jakarta.validation.Valid;
import jeancarlo_moya_1b.jeancarlomoya1b.Models.DTO.PeliculaDTO;
import jeancarlo_moya_1b.jeancarlomoya1b.Services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/apiPeliculas")
@CrossOrigin
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping("/datosPeliculas")
    public ResponseEntity<?> obtenerTodos(){
        System.out.println("hola ya entre al controller");
        List<PeliculaDTO> peliculas = peliculaService.listarTodos();
        return ResponseEntity.ok(peliculas);
    }

    @PostMapping("/crearPelicula")
    public ResponseEntity<?> crearPelicula(@Valid @RequestBody PeliculaDTO peliculaDTO){

        System.out.println("Entre al endpoint: " + peliculaDTO);
        PeliculaDTO peliculaCreado = peliculaService.crearPelicula(peliculaDTO);
        return new ResponseEntity<>(peliculaCreado, HttpStatus.CREATED);
    }

    @PutMapping("/actualizarPelicula/{id}")
    public ResponseEntity<PeliculaDTO> actualizarPelicula(@PathVariable Long id, @RequestBody @Valid PeliculaDTO peliculaDTO) {
        try {
            PeliculaDTO peliculaActualizado = peliculaService.actualizarPelicula(id, peliculaDTO);
            return ResponseEntity.ok(peliculaActualizado); // Código 200 OK
        } catch (NoSuchElementException e) {
            // Captura la excepción lanzada por el Service (ID no encontrado)
            return ResponseEntity.notFound().build(); // Código 404 Not Found
        }

    }

    @PatchMapping("/actualizarParcialPelicula/{id}")
    public ResponseEntity<PeliculaDTO> actualizarParcialPelicula(@PathVariable Long id, @RequestBody PeliculaDTO peliculaDTO) {
        try {
            PeliculaDTO peliculaActualizaado = peliculaService.actualizarPelicula(id, peliculaDTO);
            return ResponseEntity.ok(peliculaActualizaado); // Código 200 OK
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); // Código 404 Not Found
        }
    }

    @DeleteMapping("/eliminarPelicula/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Long id) {
        try {
            peliculaService.eliminarPelicula(id);
            return ResponseEntity.noContent().build(); // Código 204 No Content (Éxito sin cuerpo)
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); // Código 404 Not Found
        }
    }

}
