package pe.proyecto.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.proyecto.eventos.entity.Evento;
import pe.proyecto.eventos.entity.Imagen;
import pe.proyecto.eventos.service.IEventosService;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("evento")
public class EventoController {
    @Autowired
    private IEventosService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> listar(){
        return new ResponseEntity<>(eventoService.listar(), HttpStatus.OK);
    }

    @GetMapping("/eventosPorOrganizadorId/{organizadorId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Evento>> getEventosByOrganizadorId(@PathVariable Integer organizadorId) {
        return new ResponseEntity<>(eventoService.findAllByOrganizadorId(organizadorId), HttpStatus.OK);
    }

    @GetMapping("/eventosPorInstitucionId/{institucionId}")
    public ResponseEntity<List<Evento>> getEventosByInstitucionId(@PathVariable Integer institucionId){
        return new ResponseEntity<>(eventoService.listarPorInstitucionId(institucionId), HttpStatus.OK);
    }

    @GetMapping("/similares/{eventoId}")
    public ResponseEntity<List<Evento>> getEventosConCategoriasSimilares(@PathVariable Long eventoId, @RequestParam Integer institucionId){
        return new ResponseEntity<>(eventoService.findEventosConCategoriasSimilares(eventoId, institucionId), HttpStatus.OK);
    }

    @GetMapping("/getEventById/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id){
        return new ResponseEntity<>(eventoService.buscarPorId(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(value = {"/insertar"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Evento> insertar(@RequestPart("evento") Evento evento,
                                           @RequestPart("imageFile")MultipartFile[] file){
        try{
            Set<Imagen> imagenes = uploadImage(file);
            evento.setEventoImagenes(imagenes);

            return new ResponseEntity<>(eventoService.agregar(evento), HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(e.getMessage());

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> actualizar(@PathVariable Long id, @RequestBody Evento evento){
        return new ResponseEntity<>(eventoService.actualizar(id, evento), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        eventoService.eliminar(id);
    }

    // metodo para manejar la subida de imagenes
    public Set<Imagen> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<Imagen> imagenSet = new HashSet<>();

        for(MultipartFile file : multipartFiles){
            Imagen imageModel = new Imagen(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imagenSet.add(imageModel);
        }

        return imagenSet;
    }
}
