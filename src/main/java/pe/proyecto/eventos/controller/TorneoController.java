package pe.proyecto.eventos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.proyecto.eventos.service.ITorneoService;

@RestController
@RequestMapping("torneo")
public class TorneoController {
    private ITorneoService torneoService;
}
