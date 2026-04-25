package com.agenda.controller;

import com.agenda.model.Inscripcion;
import com.agenda.service.InscripcionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    private final InscripcionService inscripcionService;
    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @PostMapping
    public Inscripcion inscribir(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.inscribir(inscripcion);
    }
}