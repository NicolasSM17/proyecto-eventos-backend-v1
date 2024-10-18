package pe.proyecto.eventos.service;

import org.springframework.web.multipart.MultipartFile;
import pe.proyecto.eventos.entity.BoostRequest;

import java.io.IOException;
import java.util.List;

public interface IBoostRequestService {
    List<BoostRequest> listar();
    BoostRequest agregar(BoostRequest boostRequest, MultipartFile file) throws IOException;
    void marcarPeticionComoPagado(Long boostRequestId);
    void marcarPeticionComoRechazado(Long boostRequestId);
}
