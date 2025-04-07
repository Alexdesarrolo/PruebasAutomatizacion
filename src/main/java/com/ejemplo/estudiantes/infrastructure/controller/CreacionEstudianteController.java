package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.CreacionEstudianteService;
import com.ejemplo.estudiantes.domain.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("estudiantes")
@RequiredArgsConstructor
public class CreacionEstudianteController {

    private final CreacionEstudianteService creacionEstudianteService;

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        log.info("Se va crear un estudiante");
        Estudiante creado = creacionEstudianteService.crearEstudiante(estudiante);
        return new ResponseEntity<Estudiante>(creado, HttpStatus.CREATED);
    }
}
