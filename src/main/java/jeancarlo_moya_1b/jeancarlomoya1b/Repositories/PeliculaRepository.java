package jeancarlo_moya_1b.jeancarlomoya1b.Repositories;

import jeancarlo_moya_1b.jeancarlomoya1b.Entities.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {

}
