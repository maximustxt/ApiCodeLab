package com.API.CodeLab.Controllers;


import com.API.CodeLab.ExceptionCustom.ExceptionCustom;
import com.API.CodeLab.Models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Blogs")
public class BlogsController {
    @GetMapping
    public ResponseEntity<?> GetBlog(){
        return ResponseEntity.ok("LLEGO AL CONTROLLER");
        //  return ResponseEntity.ok(blogServices.GetBlogs());
    }
}
