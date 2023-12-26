package com.API.CodeLab.Services.Impl;

import com.API.CodeLab.Models.Blog;
import com.API.CodeLab.Repositorys.BlogRepository;
import com.API.CodeLab.Services.BlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServicesImpl implements BlogServices {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServicesImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> GetBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public String PostBlogs(Blog blog) {
        blogRepository.save(blog);
        return "Blog posteado con exito!";
    }

    @Override
    public List<Blog> DeleteBlogs(Long id) {
        blogRepository.deleteById(id);
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> PutBlogs(Blog blog , Long id) {
        Blog blog1 = blogRepository.findById(id).get();

        if(blog1 != null){
            blog1.setDescripcion(blog.getDescripcion());
            blog1.setImagen(blog.getImagen());
         // blog1.setImagenesDetail(blog.getImagenesDetail());
            blog1.setSubtitulo(blog.getSubtitulo());
            blog1.setTitulo(blog.getTitulo());
            blogRepository.save(blog1);
            return blogRepository.findAll();
        } else {
            new Error("Hubo un error!");
            return null;
        }
    }
}
