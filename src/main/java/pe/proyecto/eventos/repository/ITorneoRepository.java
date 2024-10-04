package pe.proyecto.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.proyecto.eventos.entity.Torneo;

@Repository
public interface ITorneoRepository extends JpaRepository<Torneo, Long> {
}
