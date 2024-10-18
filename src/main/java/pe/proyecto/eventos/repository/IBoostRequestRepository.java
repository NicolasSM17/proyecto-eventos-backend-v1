package pe.proyecto.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.proyecto.eventos.entity.BoostRequest;

@Repository
public interface IBoostRequestRepository extends JpaRepository<BoostRequest, Long> {
}
