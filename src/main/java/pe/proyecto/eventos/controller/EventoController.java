package pe.proyecto.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.proyecto.eventos.entity.Evento;
import pe.proyecto.eventos.service.IEventosService;

import java.util.List;

@RestController
@RequestMapping("evento")
public class EventoController {
    @Autowired
    private IEventosService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> listar(){
        return new ResponseEntity<>(eventoService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(eventoService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Evento> insertar(@RequestBody Evento evento){
        return new ResponseEntity<>(eventoService.agregar(evento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> actualizar(@PathVariable Long id, @RequestBody Evento evento){
        return new ResponseEntity<>(eventoService.actualizar(id, evento), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        eventoService.eliminar(id);
    }
}
