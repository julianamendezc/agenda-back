package com.agenda.controller;

import com.agenda.model.Clase;
import com.agenda.service.ClaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clases")
public class ClaseController {

    private final ClaseService claseService;

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @PostMapping
    public Clase crear(@RequestBody Clase clase) {
        return claseService.crear(clase);
    }

    @GetMapping("/dia")
    public List<Clase> porDia(@RequestParam String fecha) {
        return claseService.buscarPorDia(fecha);
    }
    @GetMapping
    public List<Clase> listar() {
        return claseService.listar();
    }

    @GetMapping("/{id}")
    public Clase buscar(@PathVariable Long id) {
        return claseService.buscarPorId(id);
    }

}