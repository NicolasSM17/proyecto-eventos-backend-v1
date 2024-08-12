package pe.proyecto.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.proyecto.eventos.entity.Evento;

import java.util.List;

@Repository
public interface IEventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findAllByOrganizadorId(Integer organizadorId);
    List<Evento> findAllByInstitucionId(Integer institucionId);
}
