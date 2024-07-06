package pe.proyecto.eventos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.proyecto.eventos.entity.Evento;
import pe.proyecto.eventos.repository.IEventoRepository;
import pe.proyecto.eventos.service.IEventosService;

import java.util.List;

@Service
public class EventoServiceImpl implements IEventosService {
    @Autowired
    private IEventoRepository eventoRepository;

    @Override
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id).get();
    }

    @Override
    public Evento agregar(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Evento actualizar(Long id, Evento evento) {
        Evento eventoBD = eventoRepository.findById(id).get();
        /* TODO */
        return eventoRepository.save(eventoBD);
    }

    @Override
    public void eliminar(Long id) {
        Evento eventoBD = eventoRepository.findById(id).get();

        eventoRepository.delete(eventoBD);
    }
}
