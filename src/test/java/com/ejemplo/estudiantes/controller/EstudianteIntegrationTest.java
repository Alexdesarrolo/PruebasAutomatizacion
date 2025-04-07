package com.ejemplo.estudiantes.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ejemplo.estudiantes.domain.Estudiante;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EstudianteIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate  restTemplate;

    @Test
    void testCrearEstudiante() {
         Estudiante estudiante = new Estudiante(1L, "carlos", "torres", 23);

        var response = restTemplate.postForEntity("/estudiantes", estudiante, Estudiante.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("carlos", response.getBody().getNombre());
    }

    @Test
    void testObtenerProducto() {
        Estudiante estudiante = new Estudiante(1L, "carlos", "torres", 23);

        restTemplate.postForEntity("/estudiantes", estudiante, Estudiante.class);

        ResponseEntity<Estudiante> response = restTemplate.getForEntity("/estudiantes" + "/1", Estudiante.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("carlos", response.getBody().getNombre());
    }

    @Test
    void testEliminarProducto() {

        Estudiante estudiante = new Estudiante(1L, "carlos", "torres", 23);
        restTemplate.postForEntity("/estudiantes", estudiante, Estudiante.class);
        restTemplate.delete("/estudiantes/1");

        ResponseEntity<Estudiante> response = restTemplate.getForEntity("/estudiantes/1", Estudiante.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
