package com.ejemplo.estudiantes.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ejemplo.estudiantes.application.mapper.EstudianteMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;

@ExtendWith(MockitoExtension.class)
public class CreacionEstudianteServiceTest {

    @Mock
    EstudianteRepository estudianteRepository;

    @InjectMocks
    private CreacionEstudianteService estudianteService;

    private EstudianteMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(EstudianteMapper.class);
        estudianteService = new CreacionEstudianteService(estudianteRepository, mapper);
    }

     @Test
    void testCrearEstudiante() {
        Estudiante estudiante = new Estudiante(2L, "Juan", "Valdes", 34);
        EstudianteEntity entity = mapper.mapToEntity(estudiante);
        when(estudianteRepository.save(entity)).thenReturn(entity);

        Estudiante resultado = estudianteService.crearEstudiante(estudiante);

        assertEquals("Juan", resultado.getNombre());
        verify(estudianteRepository).save(entity);
    }
}
