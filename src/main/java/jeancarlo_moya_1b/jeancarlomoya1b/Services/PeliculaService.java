package jeancarlo_moya_1b.jeancarlomoya1b.Services;

import jeancarlo_moya_1b.jeancarlomoya1b.Entities.PeliculaEntity;
import jeancarlo_moya_1b.jeancarlomoya1b.Models.DTO.PeliculaDTO;
import jeancarlo_moya_1b.jeancarlomoya1b.Repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository repoPelicula;

    //Hacemos un Select a la tabla Pelicula
    public List<PeliculaDTO> listarTodos(){
        System.out.println("Entre al service");
        List<PeliculaEntity> peliculas = repoPelicula.findAll();

        List <PeliculaDTO> dtos = peliculas.stream()
                .map(this::convertirAPeliculaDTO)
                .collect(Collectors.toList());
        return dtos;
    }

    private PeliculaDTO convertirAPeliculaDTO (PeliculaEntity entity){
        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setDirector(entity.getDirector());
        dto.setGenero(entity.getGenero());
        dto.setAno_estreno(entity.getAno_estreno());
        dto.setDuracion_min(entity.getDuracion_min());
        dto.setFecha_creacion(entity.getFecha_creacion());

        return dto;
    }

    public PeliculaDTO crearPelicula (PeliculaDTO peliculaDTO){
        System.out.println("Entrando al service");
        PeliculaEntity pelicula = new PeliculaEntity();
        pelicula.setTitulo(peliculaDTO.getTitulo());
        pelicula.setDirector(peliculaDTO.getDirector());
        pelicula.setGenero(peliculaDTO.getGenero());
        pelicula.setAno_estreno(peliculaDTO.getAno_estreno());
        pelicula.setDuracion_min(peliculaDTO.getDuracion_min());
        pelicula.setFecha_creacion(peliculaDTO.getFecha_creacion());

        PeliculaEntity peliculaGuardado = repoPelicula.save(pelicula);
        System.out.println("Saliendo del service");
        return convertirAPeliculaDTO(peliculaGuardado);
    }

    //
    public PeliculaDTO actualizarPelicula(Long id, PeliculaDTO peliculaDTO){
        PeliculaEntity peliculaExistente = repoPelicula.findById(id)
                .orElseThrow(()-> new RuntimeException("Pelicula no encontrada con el id: " + id));

        peliculaExistente.setTitulo(peliculaDTO.getTitulo());
        peliculaExistente.setDirector(peliculaDTO.getDirector());
        peliculaExistente.setGenero(peliculaDTO.getGenero());
        peliculaExistente.setAno_estreno(peliculaDTO.getAno_estreno());
        peliculaExistente.setDuracion_min(peliculaDTO.getDuracion_min());
        peliculaExistente.setFecha_creacion(peliculaDTO.getFecha_creacion());

        repoPelicula.save(peliculaExistente);
        return convertirAPeliculaDTO(peliculaExistente);
    }

    public void eliminarPelicula(Long id){
        PeliculaEntity peliculaExistente = repoPelicula.findById(id)
                .orElseThrow(()-> new RuntimeException("Pelicula no encontrada con el id: " + id));

        repoPelicula.delete(peliculaExistente);
    }


}
