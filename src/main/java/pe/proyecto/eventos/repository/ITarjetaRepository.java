package pe.proyecto.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.proyecto.eventos.entity.Tarjeta;

import java.util.List;

@Repository
public interface ITarjetaRepository extends JpaRepository<Tarjeta, Long> {
    List<Tarjeta> findAllByUsuarioId(Integer usuarioId);
}
