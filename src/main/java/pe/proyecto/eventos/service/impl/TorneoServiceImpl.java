package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.proyecto.eventos.entity.Torneo;
import pe.proyecto.eventos.repository.ITorneoRepository;
import pe.proyecto.eventos.service.ITorneoService;

import java.util.List;

@Service
public class TorneoServiceImpl implements ITorneoService {
    @Autowired
    private ITorneoRepository torneoRepository;

    @Override
    public List<Torneo> listar() {
        return null;
    }

    @Override
    public Torneo agregar(Torneo torneo) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}
