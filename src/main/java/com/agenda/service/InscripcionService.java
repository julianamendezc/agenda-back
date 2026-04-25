package com.agenda.service;

import com.agenda.model.Clase;
import com.agenda.model.Inscripcion;
import com.agenda.repository.ClaseRepository;
import com.agenda.repository.InscripcionRepository;
import org.springframework.stereotype.Service;


@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final ClaseRepository claseRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository, ClaseRepository claseRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.claseRepository = claseRepository;
    }

    public Inscripcion inscribir(Inscripcion inscripcion) {

    // 1. Buscar clase real en la BD
    Clase clase = claseRepository.findById(
        inscripcion.getClase().getId()
    ).orElseThrow(() -> new RuntimeException("Clase no existe"));

    // 2. Ver cuántos ya están inscriptos
    int inscriptos = clase.getInscripciones().size();

    // 3. Si está lleno, no dejar
    if (inscriptos >= clase.getCupoMaximo()) {
        throw new RuntimeException("Cupo lleno");
    }

    // 4. Guardar inscripción
    inscripcion.setClase(clase);

    return inscripcionRepository.save(inscripcion);
}
}