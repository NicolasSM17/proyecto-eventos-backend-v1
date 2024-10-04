package pe.proyecto.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.proyecto.eventos.entity.Asistente;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAsistenteRepository extends JpaRepository<Asistente, Long> {
    Optional<Asistente> findByDni(String dni);
    List<Asistente> findAllByEventoId(Long eventoId);
}
