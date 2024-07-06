package pe.proyecto.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.proyecto.eventos.entity.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
}
