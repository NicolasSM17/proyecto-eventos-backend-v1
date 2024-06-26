package pe.proyecto.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.proyecto.eventos.entity.Rol;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByNombre(String rol);
}
