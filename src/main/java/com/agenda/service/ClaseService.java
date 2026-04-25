package com.agenda.service;

import com.agenda.model.Clase;
import com.agenda.repository.ClaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClaseService {

    private final ClaseRepository claseRepository;

    public ClaseService(ClaseRepository claseRepository) {
        this.claseRepository = claseRepository;
    }

    public Clase crear(Clase clase) {
        return claseRepository.save(clase);
    }

    public List<Clase> listar() {
        return claseRepository.findAll();
    }

    public Clase buscarPorId(Long id) {
        return claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
    }

    public List<Clase> buscarPorDia(String fecha) {

        LocalDate dia = LocalDate.parse(fecha);

        return claseRepository.findAll().stream()
                .filter(c -> c.getFechaHora().toLocalDate().equals(dia))
                .toList();
    }
}