package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.EliminacionEstudianteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("estudiantes")
@RequiredArgsConstructor
public class EliminacionEstudianteController {

    private final EliminacionEstudianteService eliminacionEstudianteService;

    @DeleteMapping("{id}")
    public void eliminarEstudiante(@PathVariable("id") Long estudianteId){
        eliminacionEstudianteService.eliminarEstudiante(estudianteId);
        System.out.println("-".repeat(100));
    }
}
