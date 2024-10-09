package pe.proyecto.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.proyecto.eventos.entity.Evento;

import java.util.List;

@Repository
public interface IEventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findAllByOrganizadorId(Integer organizadorId);
    @Query("SELECT e FROM Evento e JOIN e.instituciones i WHERE i.id = :institucionId")
    List<Evento> findAllByInstitucionId(@Param("institucionId") Integer institucionId);
}
