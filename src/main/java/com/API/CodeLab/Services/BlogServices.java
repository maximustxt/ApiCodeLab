package com.API.CodeLab.Services;

import com.API.CodeLab.Models.Blog;
import com.API.CodeLab.Models.Curso;

import java.util.List;

public interface BlogServices {
    List<Blog> GetBlogs();
    String PostBlogs(Blog blog);
    List<Blog> DeleteBlogs(Long id);
    List<Blog> PutBlogs(Blog blog , Long id);
}
