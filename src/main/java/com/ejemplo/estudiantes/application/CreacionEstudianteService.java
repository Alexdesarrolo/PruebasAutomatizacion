package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.EstudianteMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreacionEstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper mapper;

    public Estudiante crearEstudiante(Estudiante estudiante) {
        EstudianteEntity entity = mapper.mapToEntity(estudiante);
        EstudianteEntity estudianteResultante = estudianteRepository.save(entity);
        return mapper.mapToDomain(estudianteResultante);
    }
}
