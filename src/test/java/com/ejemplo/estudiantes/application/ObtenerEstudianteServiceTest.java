package com.ejemplo.estudiantes.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.ejemplo.estudiantes.application.mapper.EstudianteMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;

@ExtendWith(MockitoExtension.class)
public class ObtenerEstudianteServiceTest {
    @Mock
    private EstudianteRepository estudianteRepository;

    @InjectMocks
    private VerEstudianteService estudianteService;

    private EstudianteMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(EstudianteMapper.class);
        estudianteService = new VerEstudianteService(estudianteRepository, mapper);
    }

    @Test
    void testListarEstudiantes() {
        List<EstudianteEntity> lista = Arrays.asList(new EstudianteEntity(2L, "Juan", "Valdes", 34));
        when(estudianteRepository.findAll()).thenReturn(lista);

        List<Estudiante> resultado = estudianteService.obtenerEstudiantes();

       assertEquals(1, resultado.size());
        assertEquals("Valdes", resultado.get(0).getNombre());
        verify(estudianteRepository).findAll();
    }

    @Test
    void testObtenerEstudiantePorId() {
        Estudiante estudiante = new Estudiante(2L, "Valdes", "Juan", 34);
        when(estudianteRepository.findById(1L)).thenReturn(Optional.of(mapper.mapToEntity(estudiante)));

        Estudiante resultado = estudianteService.obtenerEstudiante(1L);

        assertTrue(resultado != null);
        assertEquals("Valdes", resultado.getNombre());
        verify(estudianteRepository).findById(1L);
    }
}
