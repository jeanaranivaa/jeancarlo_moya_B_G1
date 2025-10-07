package jeancarlo_moya_1b.jeancarlomoya1b.Models.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@ToString @EqualsAndHashCode
public class PeliculaDTO {

    private Long id;


    private String titulo;

    @NotNull(message = "El director de la pelicula es obligatorio")
    private String director;

    @NotNull(message = "El genero de la pelicula es obligatorio")
    private String genero;

    @NotNull(message = "El año de estreno de la pelicula es obligatorio")
    private int ano_estreno;

    @NotNull(message = "La duración en minutos de la pelicula es obligatoria")
    private int duracion_min;

    @NotNull(message = "La fecha de creacion de la pelicula es obligatoria")
    private LocalDate fecha_creacion;
}
