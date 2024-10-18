package pe.proyecto.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.proyecto.eventos.entity.ImageCloudinary;

@Repository
public interface ImageCloudinaryRepository extends JpaRepository<ImageCloudinary, Long> {
}
