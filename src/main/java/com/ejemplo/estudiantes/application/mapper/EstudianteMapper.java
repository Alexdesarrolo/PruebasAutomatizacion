package com.ejemplo.estudiantes.application.mapper;

import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infrastructure.repository.model.EstudianteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    //EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    EstudianteEntity mapToEntity(Estudiante estudiante);

    Estudiante mapToDomain(EstudianteEntity estudianteEntity);
}
