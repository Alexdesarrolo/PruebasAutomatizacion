package com.ejemplo.estudiantes.application;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ejemplo.estudiantes.infrastructure.repository.EstudianteRepository;

@ExtendWith(MockitoExtension.class)
public class EliminacionEstudianteServiceTest {
     @Mock
    EstudianteRepository estudianteRepository;

    @InjectMocks
    private EliminacionEstudianteService estudianteService;

    void testEliminarEstudiante(){
        Long id = 2L;

        estudianteService.eliminarEstudiante(id);

        verify(estudianteRepository).deleteById(50L);
    }
}
