package com.API.CodeLab.Controllers;

import com.API.CodeLab.ExceptionCustom.ExceptionCustom;
import com.API.CodeLab.Models.Curso;
import com.API.CodeLab.Services.CursoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cursos")
public class CursoController {

    @Autowired
    private CursoServices cursoServices;

    @GetMapping
    public ResponseEntity<List<Curso>> GetCurso() {
        return ResponseEntity.ok(cursoServices.GetCursos());
    }

    @PostMapping
    public ResponseEntity<String> PostCurso(@RequestBody Curso curso) {
        if (curso.getDescripcion() == null || curso.getImagen() == null || curso.getVideos() == null || curso.getSubtitulo() == null || curso.getTitulo() == null) {
            throw new ExceptionCustom("Faltan datos para crear un curso!");
        } else {
            return ResponseEntity.ok(cursoServices.PostCursos(curso));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Curso>> DeleteCurso(@PathVariable Long id) {
        if (id == null) {
            throw new ExceptionCustom("No se encontro el curso!");
        } else {
            return ResponseEntity.ok(cursoServices.DeleteCursos(id));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Curso>> PutCurso(@RequestBody Curso curso, @PathVariable Long id) {
        if (id == null) {
            throw new ExceptionCustom("No se encontro el curso!");
        } else if (curso.getDescripcion() == null || curso.getImagen() == null || curso.getVideos() == null || curso.getSubtitulo() == null || curso.getTitulo() == null) {
            throw new ExceptionCustom("Faltan datos para crear un curso!");
        } else {
            return ResponseEntity.ok(cursoServices.PutCursos(curso, id));
        }
    }
}