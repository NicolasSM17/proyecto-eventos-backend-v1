package pe.proyecto.eventos.service;

import org.springframework.web.multipart.MultipartFile;
import pe.proyecto.eventos.entity.ImageCloudinary;

import java.io.IOException;

public interface ImageCloudinaryService {
    ImageCloudinary uploadImage(MultipartFile file) throws IOException;
    void deleteImage(ImageCloudinary image) throws IOException;
}
