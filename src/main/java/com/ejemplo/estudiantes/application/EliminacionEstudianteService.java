package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EliminacionEstudianteService {

    private final EstudianteRepository estudianteRepository;

    public void eliminarEstudiante(Long estudianteId) {
        estudianteRepository.deleteById(estudianteId);

    }
}
