package com.example.pruebaFinal.controller;

import com.example.pruebaFinal.modelo.entidades.Curso;
import com.example.pruebaFinal.modelo.entidades.Estudiante;
import com.example.pruebaFinal.service.CursoServicio;
import com.example.pruebaFinal.service.EstudianteServicio;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Scope("session")
@Component
@Data
public class EstudianteBean {

    private String nombres;
    private String apellidos;
    private String cedula;
    private Boolean activo;

    List<Estudiante> estudianteList;

    List<Curso> cursoList;

    private EstudianteServicio estudianteServicio;

    private CursoServicio cursoServicio;

    @Autowired
    public EstudianteBean(EstudianteServicio estudianteServicio,
                          CursoServicio cursoServicio) {
        this.estudianteServicio = estudianteServicio;
        this.cursoServicio = cursoServicio;
    }

    @PostConstruct
    private void init() {
        cargarListas();
    }

    public void cargarListas() {
        estudianteList = estudianteServicio.obtenerEstudiantes();
        cursoList = cursoServicio.todos();
    }

    public void guardar() {

        Estudiante estudiante = new Estudiante();
        estudiante.setNombres(nombres);
        estudiante.setApellidos(apellidos);
        estudiante.setCedula(cedula);
        estudiante.setActivo(activo);

        estudianteServicio.guardar(estudiante);

        cargarListas();

    }

}
