package jeancarlo_moya_1b.jeancarlomoya1b.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "PELICULAS")
@Getter @Setter @ToString @EqualsAndHashCode
public class PeliculaEntity {

    @Id
    @SequenceGenerator(name = "seq_peliculas", sequenceName = "SEQ_PELICULAS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_peliculas")
    @Column(name = "ID_PELICULA")
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "ANO_ESTRENO")
    private Number ano_estreno;

    @Column(name = "DURACION_MIN")
    private Number duracion_min;

    @Column(name = "FECHA_CREACION")
    private Date fecha_creacion;
}
