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
        List<PeliculaEntity> peliculas = repoPelicula.findAll();

        List <PeliculaDTO> dtos = peliculas.stream()
                .map(this::convertirAPeliculaDTO)
                .collect(Collectors.toList());
        return dtos;
    }

    private PeliculaDTO convertirAPeliculaDTO (PeliculaEntity peliculaEntity){
        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(peliculaEntity.getId());
        dto.setTitulo(peliculaEntity.getTitulo());
        dto.setDirector(peliculaEntity.getDirector());
        dto.setGenero(peliculaEntity.getGenero());
        dto.setAno_estreno(peliculaEntity.getAno_estreno());
        dto.setDuracion_min(peliculaEntity.getDuracion_min());
        dto.setFecha_creacion(peliculaEntity.getFecha_creacion());

        return dto;
    }

    public PeliculaDTO crearPelicula (PeliculaDTO peliculaDTO){
        PeliculaEntity pelicula = new PeliculaEntity();
        peliculaDTO.setId(null);
        peliculaDTO.setTitulo(peliculaDTO.getTitulo());
        peliculaDTO.setDirector(peliculaDTO.getDirector());
        peliculaDTO.setGenero(peliculaDTO.getGenero());
        peliculaDTO.setAno_estreno(peliculaDTO.getAno_estreno());
        peliculaDTO.setDuracion_min(peliculaDTO.getDuracion_min());
        peliculaDTO.setFecha_creacion(peliculaDTO.getFecha_creacion());

        PeliculaEntity peliculaGuardado = repoPelicula.save(pelicula);
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
