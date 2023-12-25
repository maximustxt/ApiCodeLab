package com.API.CodeLab.Services.Impl;

import com.API.CodeLab.Models.Curso;
import com.API.CodeLab.Models.Video;
import com.API.CodeLab.Repositorys.CursoRepository;
import com.API.CodeLab.Services.CursoServices;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoServicesImpl implements CursoServices {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoServicesImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> GetCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public String PostCursos(Curso curso) {
        cursoRepository.save(curso);
        return "Curso posteado con exito!";
    }

    @Override
    public List<Curso> DeleteCursos(Long id) {
        cursoRepository.deleteById(id);
        return cursoRepository.findAll();
    }

    @Override
    public List<Curso> PutCursos(Curso curso , Long id) {
        Curso curso1 = cursoRepository.findById(id).get();

        if(curso1 != null){
            curso1.setDescripcion(curso.getDescripcion());
            curso1.setImagen(curso.getImagen());
            curso1.setVideos(curso.getVideos());
            curso1.setSubtitulo(curso.getSubtitulo());
            curso1.setTitulo(curso.getTitulo());
            cursoRepository.save(curso1);
            return cursoRepository.findAll();
        } else {
            new Error("Hubo un error!");
            return null;
        }
    }
}
