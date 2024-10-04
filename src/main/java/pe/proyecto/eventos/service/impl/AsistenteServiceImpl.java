package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.proyecto.eventos.entity.Asistente;
import pe.proyecto.eventos.repository.IAsistenteRepository;
import pe.proyecto.eventos.service.IAsistenteService;

import java.util.List;

@Service
public class AsistenteServiceImpl implements IAsistenteService {
    @Autowired
    private IAsistenteRepository asistenteRepository;

    @Override
    public List<Asistente> listar() {
        return asistenteRepository.findAll();
    }

    @Override
    public List<Asistente> listarPorEventoId(Long eventoId) {
        return asistenteRepository.findAllByEventoId(eventoId);
    }
}
