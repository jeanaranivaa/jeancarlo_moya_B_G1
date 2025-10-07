package jeancarlo_moya_1b.jeancarlomoya1b.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "PELICULAS")
@Getter @Setter @ToString @EqualsAndHashCode
public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PELICULAS")
    @SequenceGenerator(name = "SEQ_PELICULAS", sequenceName = "SEQ_PELICULAS", allocationSize = 1)
    @Column(name = "ID_PELICULA")
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "ANO_ESTRENO")
    private int ano_estreno;

    @Column(name = "DURACION_MIN")
    private int duracion_min;

    @Column(name = "FECHA_CREACION")
    private LocalDate fecha_creacion;
}
