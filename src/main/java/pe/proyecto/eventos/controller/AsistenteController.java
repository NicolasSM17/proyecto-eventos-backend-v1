package pe.proyecto.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.proyecto.eventos.entity.Asistente;
import pe.proyecto.eventos.service.IAsistenteService;

import java.util.List;

@RestController
@RequestMapping("asistente")
public class AsistenteController {
    @Autowired
    private IAsistenteService asistenteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Asistente>> listar(){
        return new ResponseEntity<>(asistenteService.listar(), HttpStatus.OK);
    }

    @GetMapping("/asistentesPorEventoId/{eventoId}")
    public ResponseEntity<List<Asistente>> getAsistenteByEventoId(@PathVariable Long eventoId){
        return new ResponseEntity<>(asistenteService.listarPorEventoId(eventoId), HttpStatus.OK);
    }
}
