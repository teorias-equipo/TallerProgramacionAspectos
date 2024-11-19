package edu.javeriana.tallernotasAOP.servicios;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import edu.javeriana.tallernotasAOP.modelo.Estudiante;
import edu.javeriana.tallernotasAOP.repositorio.RepositorioEstudiante;

@Service
public class ServiciosEstudiante{
    @Autowired
    private RepositorioEstudiante repoEstudiante;
    
    public Estudiante guardarEstudiante(Estudiante estudiante){
        return repoEstudiante.save(estudiante);
    }

}
