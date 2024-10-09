package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.proyecto.eventos.entity.Deporte;
import pe.proyecto.eventos.repository.IDeporteRepository;
import pe.proyecto.eventos.service.IDeporteService;

import java.util.List;

@Service
public class DeporteServiceImpl implements IDeporteService {
    @Autowired
    private IDeporteRepository deporteRepository;

    @Override
    public List<Deporte> listar() {
        return deporteRepository.findAll();
    }

    @Override
    public Deporte buscarPorId(Integer id) {
        return deporteRepository.findById(id).get();
    }

    @Override
    public Deporte agregar(Deporte deporte) {
        return deporteRepository.save(deporte);
    }

    @Override
    public Deporte actualizar(Integer id, Deporte deporte) {
        Deporte deporteBD = deporteRepository.findById(id).get();

        deporteBD.setNombre(deporte.getNombre());

        return deporteRepository.save(deporteBD);
    }

    @Override
    public void eliminar(Integer id) {
        Deporte deporteBD = deporteRepository.findById(id).get();

        deporteRepository.delete(deporteBD);
    }
}
