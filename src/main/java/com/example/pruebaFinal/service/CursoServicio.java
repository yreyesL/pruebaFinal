package com.example.pruebaFinal.service;

import com.example.pruebaFinal.modelo.entidades.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CursoServicio {

    private RestTemplate restTemplate;
    private final String URI_ROOT = "http://localhost:8090/principal/cursos/";

    @Autowired
    public CursoServicio(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Curso> todos() {
        ResponseEntity<Curso[]> responseEntity = restTemplate.getForEntity(URI_ROOT+"todo", Curso[].class);
        return Arrays.asList(responseEntity.getBody());
    }
}
