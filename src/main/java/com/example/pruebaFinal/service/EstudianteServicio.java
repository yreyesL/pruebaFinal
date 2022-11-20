package com.example.pruebaFinal.service;

import com.example.pruebaFinal.modelo.entidades.Estudiante;
import com.example.pruebaFinal.repo.Crud.EstudiantesCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicio {

    private EstudiantesCrud estudiantesCrud;

    @Autowired
    public EstudianteServicio(EstudiantesCrud estudiantesCrud) {
        this.estudiantesCrud = estudiantesCrud;
    }

    public List<Estudiante> obtenerEstudiantes() {
        return (List<Estudiante>) estudiantesCrud.findAll();
    }

    public void guardar(Estudiante estudiante) {
        estudiantesCrud.save(estudiante);
    }

}
