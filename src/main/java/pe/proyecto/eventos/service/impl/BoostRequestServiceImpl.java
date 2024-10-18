package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.proyecto.eventos.entity.BoostRequest;
import pe.proyecto.eventos.entity.EstadoBoost;
import pe.proyecto.eventos.entity.ImageCloudinary;
import pe.proyecto.eventos.repository.IBoostRequestRepository;
import pe.proyecto.eventos.service.IBoostRequestService;
import pe.proyecto.eventos.service.ICloudinaryService;
import pe.proyecto.eventos.service.ImageCloudinaryService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BoostRequestServiceImpl implements IBoostRequestService {
    @Autowired
    private IBoostRequestRepository boostRequestRepository;

    @Autowired
    private ImageCloudinaryService imageService;

    @Override
    public List<BoostRequest> listar() {
        return boostRequestRepository.findAll();
    }

    @Override
    public BoostRequest agregar(BoostRequest boostRequest, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()){
            ImageCloudinary image = imageService.uploadImage(file);
            boostRequest.setImage(image);
        }

        // Configurar valores predeterminados
        boostRequest.setEstado(EstadoBoost.PENDIENTE); // Estado inicial por defecto
        boostRequest.setFechaSolicitud(LocalDate.now()); // Fecha de solicitud actual

        return boostRequestRepository.save(boostRequest);
    }

    @Override
    public void marcarPeticionComoPagado(Long boostRequestId) {
        Optional<BoostRequest> boostRequestOptional = boostRequestRepository.findById(boostRequestId);

        if (boostRequestOptional.isPresent()) {
            BoostRequest boostRequest = boostRequestOptional.get();
            boostRequest.setEstado(EstadoBoost.CONFIRMADO);
            boostRequest.getEvento().setBoost(true); // Marcar el evento como impulsado (boost activo)

            boostRequestRepository.save(boostRequest);
        } else {
            throw new IllegalArgumentException("No se encontró la solicitud de boost con ID: " + boostRequestId);
        }
    }

    @Override
    public void marcarPeticionComoRechazado(Long boostRequestId) {
        Optional<BoostRequest> boostRequestOptional = boostRequestRepository.findById(boostRequestId);

        if (boostRequestOptional.isPresent()) {
            BoostRequest boostRequest = boostRequestOptional.get();
            boostRequest.setEstado(EstadoBoost.DECLINADO);

            boostRequestRepository.save(boostRequest);
        } else {
            throw new IllegalArgumentException("No se encontró la solicitud de boost con ID: " + boostRequestId);
        }
    }
}
