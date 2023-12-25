package com.API.CodeLab.Services;


import com.API.CodeLab.Models.Curso;
import java.util.List;

public interface CursoServices {
List<Curso> GetCursos();
String PostCursos(Curso curso);
List<Curso> DeleteCursos(Long id);
List<Curso> PutCursos(Curso curso , Long id);

}
