package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.proyecto.eventos.entity.ImageCloudinary;
import pe.proyecto.eventos.repository.ImageCloudinaryRepository;
import pe.proyecto.eventos.service.ICloudinaryService;
import pe.proyecto.eventos.service.ImageCloudinaryService;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageCloudinaryServiceImpl implements ImageCloudinaryService {
    @Autowired
    private ICloudinaryService cloudinaryService;

    @Autowired
    private ImageCloudinaryRepository imageRepository;

    @Override
    public ImageCloudinary uploadImage(MultipartFile file) throws IOException {
        Map uploadResult = cloudinaryService.upload(file);
        String imageUrl = (String) uploadResult.get("url");
        String imageId = (String) uploadResult.get("public_id");
        ImageCloudinary image = new ImageCloudinary(file.getOriginalFilename(), imageUrl, imageId);

        return imageRepository.save(image);
    }

    @Override
    public void deleteImage(ImageCloudinary image) throws IOException {
        cloudinaryService.delete(image.getImageId());
        imageRepository.deleteById(image.getId());
    }
}
