package pe.proyecto.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.proyecto.eventos.entity.BoostRequest;
import pe.proyecto.eventos.service.IBoostRequestService;

import java.util.List;

@RestController
@RequestMapping("boost")
public class BoostRequestController {
    @Autowired
    private IBoostRequestService boostRequestService;

    @GetMapping("/listar")
    public ResponseEntity<List<BoostRequest>> listar(){
        return new ResponseEntity<>(boostRequestService.listar(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BoostRequest> generar(@RequestPart("boostRequest") BoostRequest boostRequest,
                                                @RequestPart("file") MultipartFile file){
        try{
            BoostRequest nuevaSolicitud = boostRequestService.agregar(boostRequest, file);

            return new ResponseEntity<>(nuevaSolicitud, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/marcarPeticionComoPagado/{boostRequestId}")
    public void marcarPeticionComoPagado(@PathVariable Long boostRequestId){
        boostRequestService.marcarPeticionComoPagado(boostRequestId);
    }

    @PatchMapping("/marcarPeticionComoRechazado/{boostRequestId}")
    public void marcarPeticionComoRechazado(@PathVariable Long boostRequestId){
        boostRequestService.marcarPeticionComoRechazado(boostRequestId);
    }
}
