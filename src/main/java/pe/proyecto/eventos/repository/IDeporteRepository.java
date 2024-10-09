package pe.proyecto.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.proyecto.eventos.entity.Deporte;

@Repository
public interface IDeporteRepository extends JpaRepository<Deporte, Integer> {
}
