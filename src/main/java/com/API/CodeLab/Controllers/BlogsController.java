package com.API.CodeLab.Controllers;


import com.API.CodeLab.ExceptionCustom.ExceptionCustom;
import com.API.CodeLab.Models.Blog;
import com.API.CodeLab.Services.BlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Blogs")
public class BlogsController {

    @Autowired
    private BlogServices blogServices;

    @GetMapping
    public ResponseEntity<List<Blog>> GetBlog(){
        return ResponseEntity.ok(blogServices.GetBlogs());
    }

    @PostMapping
    public ResponseEntity<String> PostBlogs(@RequestBody Blog blog){
      /*  if(blog.getDescripcion() == null || blog.getImagen() == null || blog.getImagenesDetail() == null || blog.getSubtitulo() == null || blog.getTitulo() == null) {
            throw new ExceptionCustom("Faltan datos para poder crear el blog");
        } else {
            return ResponseEntity.ok(blogServices.PostBlogs(blog));
        }*/
        return ResponseEntity.ok(blogServices.PostBlogs(blog));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Blog>> DeleteBlog(@PathVariable Long id){
        if(id == null){
            throw new ExceptionCustom("El blog no se encontro");
        } else {
            return ResponseEntity.ok(blogServices.DeleteBlogs(id));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Blog>> PutBlog(@RequestBody Blog blog , @PathVariable Long id ){
        if(id == null){
            throw new ExceptionCustom("El blog no se encontro");
        } else if(blog.getDescripcion() == null || blog.getImagen() == null || blog.getImagenesDetail() == null || blog.getSubtitulo() == null || blog.getTitulo() == null) {
            throw new ExceptionCustom("Faltan datos para poder crear el blog");
        } else {
            return ResponseEntity.ok(blogServices.PutBlogs(blog , id));
        }
    }
}
