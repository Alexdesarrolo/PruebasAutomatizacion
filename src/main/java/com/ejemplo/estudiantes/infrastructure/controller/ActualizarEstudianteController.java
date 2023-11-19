package com.ejemplo.estudiantes.infrastructure.controller;

import com.ejemplo.estudiantes.application.CreacionEstudianteService;
import com.ejemplo.estudiantes.application.VerEstudianteService;
import com.ejemplo.estudiantes.domain.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("estudiantes")
@RequiredArgsConstructor
public class ActualizarEstudianteController {
    private final CreacionEstudianteService creacionEstudianteService;
    private final VerEstudianteService verEstudianteService;

    //@PostMapping("{id}")
    @PutMapping("{id}")
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante, @PathVariable("id") Long estudianteId) {
        log.info("Se va modificar un estudiante");
        Estudiante estudianteAct = verEstudianteService.obtenerEstudiante(estudianteId);

        //Actualizamos los datos
        estudianteAct.setNombre(estudiante.getNombre());
        estudianteAct.setApellido(estudiante.getApellido());
        estudianteAct.setEdad(estudiante.getEdad());

        return creacionEstudianteService.crearEstudiante(estudianteAct);
    }
}
