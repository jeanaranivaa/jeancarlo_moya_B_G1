package jeancarlo_moya_1b.jeancarlomoya1b.Models.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString @EqualsAndHashCode
@Getter @Setter
public class PeliculaDTO {

    private Long id;

    @NotNull(message = "El titulo de la pelicula es obligatorio")
    private String titulo;

    @NotNull(message = "El director de la pelicula es obligatorio")
    private String director;

    @NotNull(message = "El genero de la pelicula es obligatorio")
    private String genero;

    @NotNull(message = "El año de estreno de la pelicula es obligatorio")
    private Number ano_estreno;

    @NotNull(message = "La duración en minutos de la pelicula es obligatoria")
    private Number duracion_min;

    @NotNull(message = "La fecha de creacion de la pelicula es obligatoria")
    private Date fecha_creacion;
}
