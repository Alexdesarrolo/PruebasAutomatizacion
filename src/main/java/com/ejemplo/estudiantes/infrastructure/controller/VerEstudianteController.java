package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.VerEstudianteService;
import com.ejemplo.estudiantes.domain.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("estudiantes")
@RequiredArgsConstructor
public class VerEstudianteController {

    private final VerEstudianteService verEstudianteService;

    @GetMapping
    public List<Estudiante> obtenerEstudiantes() {
        log.info("Se están pidiendo todos los estudiantes");
        return verEstudianteService.obtenerEstudiantes();
    }

    @GetMapping("{id}")
    public ResponseEntity<Estudiante> obtenerEstudiante(@PathVariable("id") Long estudianteId) {
        Estudiante estudiante = verEstudianteService.obtenerEstudiante(estudianteId);
    
    if (estudiante != null) {
        return ResponseEntity.ok(estudiante); // 200 OK con el estudiante en el cuerpo
    } else {
        return ResponseEntity.notFound().build(); // 404 Not Found
    }
    }
}
