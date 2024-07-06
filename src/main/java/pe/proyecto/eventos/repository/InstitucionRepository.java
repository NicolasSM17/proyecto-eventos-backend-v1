package pe.proyecto.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.proyecto.eventos.entity.Institucion;

@Repository
public interface InstitucionRepository extends JpaRepository<Institucion, Integer> {
}
