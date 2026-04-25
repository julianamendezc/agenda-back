package com.agenda.controller;

import com.agenda.model.Usuario;
import com.agenda.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return usuarioService.registrar(
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getPassword()
        );
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        return usuarioService.login(
                usuario.getEmail(),
                usuario.getPassword()
        );
    }
}